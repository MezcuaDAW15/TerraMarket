import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { BannerComponent } from "../banner/banner.component";
import { ListComponent } from "../list/list.component";
import { Mercado } from '../../models/mercado';
import { Router, RouterLink } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { MarketService } from '../../services/markets/market.service';
import { TabMenuModule } from 'primeng/tabmenu';
import { MenuItem } from 'primeng/api';
import { MarketListTiendasComponent } from "../market-list-tiendas/market-list-tiendas.component";




@Component({
  selector: 'app-market-view',
  standalone: true,
  imports: [BackComponent, BannerComponent, CommonModule, ListComponent, TabMenuModule, MarketListTiendasComponent],
  templateUrl: './market-view.component.html',
  styleUrl: './market-view.component.scss'
})
export class MarketViewComponent implements OnInit {
  activeTab: string = 'shop';
  selectedItem: any;

  mercado: Mercado | null = null;
  errorMessage: string = '';
  items: MenuItem[] | undefined;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private marketService: MarketService
  ) { }

  ngOnInit(): void {
    const routerMap = new Map<number, string>();
    //Crear servicio que devuelva el map de rutas


    const id = Number(this.route.snapshot.paramMap.get('id'));
    console.log(this.router.url)

    if (!isNaN(id) && id > 0) {
      // Solo llama al servicio si el ID es válido
      this.marketService.findById(id).subscribe({
        next: (data) => {
          this.mercado = data;
          console.log(this.mercado)
        },
        error: (error) => {
          console.error('Error al cargar el mercado:', error);
          this.errorMessage = 'No se pudo cargar la información del mercado.';
        }
      });
    } else {
      this.errorMessage = 'ID de mercado no válido.';
      console.error('ID de mercado no válido:', id);
    }

    this.items = [
      { label: 'Tiendas', icon: 'shop', command: () => this.setActiveTab('shop') },
      { label: 'Productos', icon: 'products', command: () => this.setActiveTab('products') }
    ];
    this.selectedItem = this.items ? this.items[0] : null;

  }

  setActiveTab(tab: string) {
    this.activeTab = tab;
  }

  onTabChange(event: any) {
    this.activeTab = event.index === 0 ? 'products' : 'shop';
    if (this.selectedItem) {
      this.selectedItem = this.items ? [event.index] : null;
    }
    console.log(this.activeTab)
  }
}
