import { Component } from '@angular/core';
import { DialogModule } from 'primeng/dialog';
import { FiltrosComponent } from "../filtros/filtros.component";
import { CategoriaP } from '../../models/categoriaP';
import { ProductosService } from '../../services/productos/productos.service';


@Component({
  selector: 'app-list',
  standalone: true,
  imports: [DialogModule, FiltrosComponent],
  templateUrl: './list.component.html',
  styleUrl: './list.component.scss'
})
export class ListComponent {
  constructor(
    private productoService: ProductosService
  ) { }
  selectedFilters: CategoriaP[] = [];

  onFiltersApplied(categories: CategoriaP[]) {
    this.selectedFilters = categories;
    this.visible = false; // Cerrar el diálogo después de aplicar
    const productos = this.productoService.findByCategories(categories);
    console.log(productos.forEach(producto => producto.forEach(productoo => console.log(productoo.nombre))));
  }

  visible: boolean = false;

  showFilters() {
    this.visible = true;
    console.log('showFilters');
  }

}
