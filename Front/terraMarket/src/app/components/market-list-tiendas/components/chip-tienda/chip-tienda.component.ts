import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoriaT } from '../../../../models/categoriaT';

@Component({
  selector: 'app-chip-tienda',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './chip-tienda.component.html',
  styleUrl: './chip-tienda.component.scss'
})
export class ChipTiendaComponent implements OnInit {

  @Input() categoria: CategoriaT | null = null;
  @Input() categoriaActiva: CategoriaT | null = null;
  activo: boolean = false;

  ngOnInit(): void {
    if (this.categoria && this.categoriaActiva && this.categoria.id === this.categoriaActiva.id) {
      this.activo = true;
    }
  }
  toggleCategory() {
    this.activo = !this.activo;
  }


}
