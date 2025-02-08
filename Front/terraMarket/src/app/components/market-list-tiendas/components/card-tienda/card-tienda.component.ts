import { Component, Input } from '@angular/core';
import { Tienda } from '../../../../models/tienda';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card-tienda',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-tienda.component.html',
  styleUrl: './card-tienda.component.scss'
})
export class CardTiendaComponent {
  @Input() tienda: Tienda | null = null;

}
