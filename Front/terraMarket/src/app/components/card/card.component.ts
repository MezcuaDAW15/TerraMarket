import { VentasService } from './../../services/ventas/ventas.service';
import { Component, Input, OnInit } from '@angular/core';
import { Producto } from '../../models/producto';
import { Venta } from '../../models/venta';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent implements OnInit {
  @Input() producto: Producto | null = null;
  ventas: Venta[] = [];

  constructor(private ventasService: VentasService) { }

  ngOnInit() {
    if (this.producto) {
      this.ventasService.findAllByProducto(this.producto).subscribe(ventas => {
        this.ventas = ventas;
      });
    }
  }
}
