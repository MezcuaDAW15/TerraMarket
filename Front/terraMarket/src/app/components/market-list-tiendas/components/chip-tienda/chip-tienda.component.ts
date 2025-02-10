import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoriaT } from '../../../../models/categoriaT';

@Component({
  selector: 'app-chip-tienda',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './chip-tienda.component.html',
  styleUrl: './chip-tienda.component.scss'
})
export class ChipTiendaComponent {

  @Input() categoria: CategoriaT | null = null;
  activo: boolean = false;
  toggleCategory() {
    this.activo = !this.activo;
  }


}
