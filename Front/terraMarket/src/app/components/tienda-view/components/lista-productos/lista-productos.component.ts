import { Component, Input, OnInit } from '@angular/core';
import { CategoriaP } from '../../../../models/categoriaP';
import { Mercado } from '../../../../models/mercado';
import { Venta } from '../../../../models/venta';
import { ProductosService } from '../../../../services/productos/productos.service';
import { VentasService } from '../../../../services/ventas/ventas.service';
import { Tienda } from '../../../../models/tienda';
import { DialogModule } from 'primeng/dialog';
import { CommonModule } from '@angular/common';
import { CardComponent } from '../../../card/card.component';
import { FiltrosComponent } from '../../../filtros/filtros.component';

@Component({
  selector: 'app-lista-productos',
  standalone: true,
  imports: [DialogModule, FiltrosComponent, CardComponent, CommonModule],
  templateUrl: './lista-productos.component.html',
  styleUrl: './lista-productos.component.scss',
})
export class ListaProductosComponent implements OnInit {
  constructor(
    private productoService: ProductosService,
    private ventasService: VentasService
  ) {}

  @Input() tienda: Tienda | null = null;

  selectedFilters: CategoriaP[] = [];
  productsToShow: Venta[] = [];
  visible: boolean = false;

  ngOnInit(): void {
    if (this.tienda) {
      this.ventasService
        .findByVentasTienda([], this.tienda)
        .subscribe((venta) => {
          this.productsToShow = venta;
          console.log(this.productsToShow);
        });
    }
  }

  onFiltersApplied(categories: CategoriaP[], tienda: Tienda) {
    this.selectedFilters = categories;
    this.visible = false; // Cerrar el diálogo después de aplicar

    // Limpiar el array antes de actualizarlo
    this.productsToShow = [];

    // Obtener productos filtrados y aplanar el array
    this.ventasService
      .findByVentasTienda(categories, tienda)
      .subscribe((venta) => {
        this.productsToShow = venta;
        console.log(this.productsToShow);
      });
  }

  showFilters() {
    this.visible = true;
    console.log('showFilters');
  }

  trackByFn(index: number, item: any) {
    return item.id;
  }
}
