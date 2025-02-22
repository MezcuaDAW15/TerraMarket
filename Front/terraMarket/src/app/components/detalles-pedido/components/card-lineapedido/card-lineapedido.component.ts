import { LineaPedido } from './../../../../models/lineaPedido';
import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ValoracionesService } from '../../../../services/valoraciones/valoraciones.service';
import { Cliente } from '../../../../models/cliente';

@Component({
  selector: 'app-card-lineapedido',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-lineapedido.component.html',
  styleUrl: './card-lineapedido.component.scss',
})
export class CardLineapedidoComponent implements OnInit {
  @Input() lineaPedido: LineaPedido | null = null;
  imagenUrl: string | null = null;
  @Input() cliente!: Cliente | null;

  ngOnInit(): void {
    this.imagenUrl =
      'data:image/jpeg;base64,' + this.lineaPedido?.venta.producto.imagen;
  }

  constructor(
    private router: Router,
    private valoracionesService: ValoracionesService
  ) {}

  irAValoracion(lineaPedido: LineaPedido | null): void {
    if (!lineaPedido) {
      console.error('Error: LineaPedido es null');
      return;
    }
    const datosValoracion = {
      tienda: lineaPedido?.venta.tienda,
      cliente: this.cliente,
    };

    // Guardar los datos en el servicio
    this.valoracionesService.setDatosValoracion(datosValoracion);

    // Redirigir a la pantalla de valoración
    this.router.navigate(['/valoracion']);
  }
}
