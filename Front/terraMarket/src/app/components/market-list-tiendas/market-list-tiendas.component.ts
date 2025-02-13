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
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-market-list-tiendas',
  standalone: true,
  imports: [CardTiendaComponent, CommonModule, ChipTiendaComponent],
  templateUrl: './market-list-tiendas.component.html',
  styleUrl: './market-list-tiendas.component.scss'
})
export class MarketListTiendasComponent implements OnInit {
  @Input() mercado: Mercado | null = null;

  categorias: CategoriaT[] = [];
  tiendas: Tienda[] = [];
  categoriasSeleccionadas: CategoriaT[] = [];

  constructor(
    private categoriesService: CategoriesService,
    private tiendaService: TiendasService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.categoriesService.findAll().subscribe((data) => {
      this.categorias = data;


      this.route.queryParams.subscribe((params) => {
        const categoriaId = params['categoria'];
        if (categoriaId) {
          const selectedCategory = this.categorias.find(cat => cat.id === parseInt(categoriaId, 10));
          if (selectedCategory) {
            this.toggleCategoria(selectedCategory, true);
          }
        }
      });
    });


    this.cargarTiendas();
  }

  cargarTiendas() {
    if (this.mercado) {
      this.tiendaService.findAllByMercado(this.mercado, this.categorias)
        .subscribe(tiendas => {

          if (this.categoriasSeleccionadas.length > 0) {
            this.tiendas = tiendas.filter(tienda =>
              tienda.categoriaT.some(cat =>
                this.categoriasSeleccionadas.some(selCat => selCat.id === cat.id)
              )
            );
          } else {
            this.tiendas = tiendas;
          }
        });
    }
  }

  toggleCategoria(categoria: CategoriaT, fromUrl: boolean = false) {
    const index = this.categoriasSeleccionadas.findIndex(c => c.id === categoria.id);
    if (index === -1) {
      this.categoriasSeleccionadas.push(categoria);
    } else {
      this.categoriasSeleccionadas.splice(index, 1);
    }


    if (!fromUrl) {
      this.cargarTiendas();
    }
  }

  trackByFn(index: number, item: any) {
    return item.id;
  }
  getCategoriaActiva(categoria: CategoriaT): CategoriaT | null {
    return this.categoriasSeleccionadas.find(cat => cat.id === categoria.id) || null;
  }
}
