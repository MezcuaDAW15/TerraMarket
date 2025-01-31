import { Component } from '@angular/core';
import { DialogModule } from 'primeng/dialog';
import { CategoriaP } from '../../models/categoriaP';
import { ProductosService } from '../../services/productos/productos.service';
import { FiltrosComponent } from "../filtros/filtros.component";
import { Producto } from '../../models/producto';
import { CommonModule } from '@angular/common';
import { CardComponent } from '../card/card.component';


@Component({
  selector: 'app-list',
  standalone: true,
  imports: [DialogModule, FiltrosComponent, CardComponent, CommonModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.scss'
})
export class ListComponent {
  constructor(private productoService: ProductosService) { }

  selectedFilters: CategoriaP[] = [];
  productsToShow: Producto[] = [];
  visible: boolean = false;

  onFiltersApplied(categories: CategoriaP[]) {
    this.selectedFilters = categories;
    this.visible = false; // Cerrar el diálogo después de aplicar

    // Limpiar el array antes de actualizarlo
    this.productsToShow = [];

    // Obtener productos filtrados y aplanar el array
    this.productoService.findByCategories(categories).subscribe(productos => {
      this.productsToShow = productos.flat(); // Aplana el array de arrays
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
