import { LineaPedido } from './../../../../models/lineaPedido';
import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card-lineapedido',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-lineapedido.component.html',
  styleUrl: './card-lineapedido.component.scss'
})
export class CardLineapedidoComponent implements OnInit {

  @Input() lineaPedido: LineaPedido | null = null;
  imagenUrl: string | null = null;


  ngOnInit(): void {
    this.imagenUrl = 'data:image/jpeg;base64,' + this.lineaPedido?.venta.producto.imagen;
  }
  formatNumber(value: number): string {
    return value.toFixed(2).replace(".", ",").padStart(5, "0");
  }
}
