import { Mercado } from './../../models/mercado';
import { map } from 'rxjs';
import { Component, Input } from '@angular/core';
import { DialogModule } from 'primeng/dialog';
import { CategoriaP } from '../../models/categoriaP';
import { ProductosService } from '../../services/productos/productos.service';
import { FiltrosComponent } from "../filtros/filtros.component";
import { Producto } from '../../models/producto';
import { CommonModule } from '@angular/common';
import { CardComponent } from '../card/card.component';
import { Venta } from '../../models/venta';
import { VentasService } from '../../services/ventas/ventas.service';
import { ChipComponent } from "../filtros/components/chip/chip.component";


@Component({
  selector: 'app-list',
  standalone: true,
  imports: [DialogModule, FiltrosComponent, CardComponent, CommonModule,
  
  ],
  templateUrl: './list.component.html',
  styleUrl: './list.component.scss'
})
export class ListComponent {

  constructor(
    private productoService: ProductosService,
    private ventasService: VentasService
  ) { }
  @Input() mercado: Mercado | null = null;


  selectedFilters: CategoriaP[] = [];
  productsToShow: Venta[] = [];
  visible: boolean = false;

  onFiltersApplied(categories: CategoriaP[], mercado: Mercado) {
    this.selectedFilters = categories;
    this.visible = false; // Cerrar el diálogo después de aplicar

    // Limpiar el array antes de actualizarlo
    this.productsToShow = [];

    // Obtener productos filtrados y aplanar el array
    this.ventasService.findByMapVentasProductos(categories, mercado).subscribe(venta => {
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
