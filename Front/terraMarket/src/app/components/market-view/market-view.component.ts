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
import { RutasService } from '../../services/rutas/rutas.service';




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
  items: MenuItem[] | undefined;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private marketService: MarketService,
    private rutaService: RutasService

  ) { }

  ngOnInit(): void {
    const routerMap = new Map<number, string>();

    this.rutaService.getRutas().subscribe({
      next: (data) => {
        for (let key in data as { [key: string]: any }) {
          routerMap.set(Number(key), (data as { [key: string]: any })[key].toString());
        }
        console.log("Router Map:", routerMap);

        // Obtener el nombre del mercado desde la URL
        const nombreMercado = this.route.snapshot.paramMap.get('nombreMercado');
        console.log("Nombre en URL:", nombreMercado);

        if (nombreMercado) {
          // Buscar el ID correspondiente en routerMap
          const mercadoId = [...routerMap.entries()]
            .find(([id, name]) => name === nombreMercado)?.[0];

          if (mercadoId) {
            this.loadMarket(mercadoId);
          } else {
            console.error("Mercado no encontrado:", nombreMercado);
          }
        } else {
          console.error("Nombre de mercado no válido en la URL.");
        }
      },
      error: (error) => {
        console.error("Error al cargar rutas:", error);
      }
    });

    this.items = [
      { label: "Tiendas", icon: "shop", command: () => this.setActiveTab("shop") },
      { label: "Productos", icon: "products", command: () => this.setActiveTab("products") }
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

  loadMarket(id: number): void {
    this.marketService.findById(id).subscribe({
      next: (data) => {
        this.mercado = data;
        console.log("Mercado cargado:", this.mercado);
      },
      error: (error) => {
        console.error("Error al cargar el mercado:", error);
      }
    });
  }
}
