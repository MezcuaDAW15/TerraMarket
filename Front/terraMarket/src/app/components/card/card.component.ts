import { VentasService } from './../../services/ventas/ventas.service';
import { Component, Input, OnInit } from '@angular/core';
import { Producto } from '../../models/producto';
import { Venta } from '../../models/venta';
import { ActivatedRoute } from '@angular/router';

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


  constructor(
    private route: ActivatedRoute,

    private ventasService: VentasService
  ) { }

  ngOnInit() {
    if (this.venta) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.venta.producto.imagen;

    }

  }

  formatNumber(value: number): string {
    if (value < 10) {
      return value.toFixed(2).replace(".", ",");
    }

    // Si el valor es mayor o igual a 10, formatea con ceros a la izquierda
    return value.toFixed(2).replace(".", ",").padStart(5, "0");
  }

  anadirCesta(nombre: string) {
    const nombreMercado = this.route.snapshot.paramMap.get('nombreMercado');

    window.location.href = `/${nombreMercado}/${this.formatString(nombre)}`;
  }
  formatString(input: string): string {
    return input
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .toLowerCase()
      .replace(/ /g, "-");
  }
}
