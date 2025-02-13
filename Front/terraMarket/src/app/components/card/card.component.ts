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
  @Input() venta: Venta | null = null;
  imagenUrl: string | null = null;


  constructor(private ventasService: VentasService) { }

  ngOnInit() {
    if (this.venta) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.venta.producto.imagen;
      // File
      // save ("producto" + id. + ".jpg")

    }

  }

  formatNumber(value: number): string {
    return value.toFixed(2).replace(".", ",").padStart(5, "0");
  }
}
