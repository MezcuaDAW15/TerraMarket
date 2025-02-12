import { CategoriesService } from './../../services/categories/categories.service';
import { Component, OnInit, Input } from '@angular/core';
import { CardMarketComponent } from "../card-market/card-market.component";
import { CardTiendaComponent } from './components/card-tienda/card-tienda.component';
import { Tienda } from '../../models/tienda';
import { CommonModule } from '@angular/common';
import { CategoriaT } from '../../models/categoriaT';
import { ChipTiendaComponent } from './components/chip-tienda/chip-tienda.component';
import { TiendasService } from '../../services/tiendas/tiendas.service';
import { Mercado } from '../../models/mercado';

@Component({
  selector: 'app-market-list-tiendas',
  standalone: true,
  imports: [CardTiendaComponent, CommonModule, ChipTiendaComponent],
  templateUrl: './market-list-tiendas.component.html',
  styleUrl: './market-list-tiendas.component.scss'
})
export class MarketListTiendasComponent implements OnInit {
  @Input() mercado: Mercado | null = null;
  constructor(
    private categoriesService: CategoriesService,
    private tiendaService: TiendasService
  ) { }
  categorias: CategoriaT[] = [];
  tiendas: Tienda[] = [];
  categoriasSeleccionadas: CategoriaT[] = [];

  ngOnInit(): void {
    this.categoriesService.findAll().subscribe((data) => {
      this.categorias = data;
    });
    if (this.mercado) {
      this.tiendaService.findAllByMercado(this.mercado, this.categorias).subscribe((data) => {
        this.tiendas = data;
      });
    }
  }

  cargarTiendas() {
    if (this.mercado) {
      this.tiendaService.findAllByMercado(this.mercado, this.categoriasSeleccionadas)
        .subscribe(tiendas => this.tiendas = tiendas);
    }

  }


  toggleCategoria(categoria: CategoriaT) {
    const index = this.categoriasSeleccionadas.findIndex(c => c.id === categoria.id);
    if (index === -1) {
      this.categoriasSeleccionadas.push(categoria);
    } else {
      this.categoriasSeleccionadas.splice(index, 1);
    }
    this.cargarTiendas(); // Actualiza la lista de tiendas según la selección
  }




  filterTiendas($event: Event) {
    throw new Error('Method not implemented.');
  }



  trackByFn(index: number, item: any) {
    return item.id;

  }


}
