import { Component, Input } from '@angular/core';
import { Pedido } from '../../../../models/pedido';

@Component({
  selector: 'app-resumen',
  standalone: true,
  imports: [],
  templateUrl: './resumen.component.html',
  styleUrl: './resumen.component.scss'
})
export class ResumenComponent {
  @Input() cesta: Pedido | null = null;


  formatNumber(value: number): string {
    return value.toFixed(2).replace(".", ",").padStart(5, "0");
  }
}
