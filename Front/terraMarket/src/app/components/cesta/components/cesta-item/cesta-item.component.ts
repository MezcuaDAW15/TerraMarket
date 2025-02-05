import { LineaPedido } from '../../../../models/lineaPedido';
import { Venta } from './../../../../models/venta';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-cesta-item',
  standalone: true,
  imports: [],
  templateUrl: './cesta-item.component.html',
  styleUrl: './cesta-item.component.scss'
})
export class CestaItemComponent {
  @Input() lineaPedido: LineaPedido | null = null;
}
