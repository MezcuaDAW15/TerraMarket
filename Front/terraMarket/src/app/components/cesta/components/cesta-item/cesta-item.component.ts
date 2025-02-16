import { CestaService } from './../../../../services/cesta/cesta.service';
import { LineaPedido } from '../../../../models/lineaPedido';
import { Venta } from './../../../../models/venta';
import { Component, Input, OnInit } from '@angular/core';
import { Cliente } from '../../../../models/cliente';
import { Router } from '@angular/router';
import { Pedido } from '../../../../models/pedido';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cesta-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cesta-item.component.html',
  styleUrl: './cesta-item.component.scss'
})
export class CestaItemComponent implements OnInit {
  constructor(
    private cestaService: CestaService,
    private router: Router
  ) { }

  cliente: Cliente | undefined;
  @Input() lineaPedido: LineaPedido | null = null;
  @Input() pedido: Pedido | null = null;
  imagenUrl: string | null = null;


  ngOnInit(): void {
    if (this.lineaPedido?.venta.producto) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.lineaPedido.venta.producto.imagen;

    }
  }

  formatNumber(value: number): string {
    if (value < 10) {
      return value.toFixed(2).replace(".", ",");
    }

    // Si el valor es mayor o igual a 10, formatea con ceros a la izquierda
    return value.toFixed(2).replace(".", ",").padStart(5, "0");
  }
  restar() {
    if (this.lineaPedido) {
      if (this.pedido) {
        this.lineaPedido.pedido = this.pedido;
      }
    }
    this.cliente = {
      id: 1,
      nombre: 'Cliente',
      apellidos: 'Apellidos',
      username: 'username',
      email: 'email',
      fechaNacimiento: new Date(),
      cp: 'cp',
    }
    console.log("Restar");
    this.cestaService.alterLineaPedido(this.lineaPedido, -1, this.cliente).subscribe((lineaPedido) => {
      this.lineaPedido = lineaPedido;

    });

  }


  sumar() {
    if (this.lineaPedido) {
      if (this.pedido) {
        this.lineaPedido.pedido = this.pedido;
      }
    }
    this.cliente = {
      id: 1,
      nombre: 'Cliente',
      apellidos: 'Apellidos',
      username: 'username',
      email: 'email',
      fechaNacimiento: new Date(),
      cp: 'cp',
    }
    console.log("Sumar");
    this.cestaService.alterLineaPedido(this.lineaPedido, 1, this.cliente).subscribe((lineaPedido) => {
      this.lineaPedido = lineaPedido;
    });
  }

  eliminar() {
    if (this.lineaPedido) {
      if (this.pedido) {
        this.lineaPedido.pedido = this.pedido;
      }
    }
    this.cliente = {
      id: 1,
      nombre: 'Cliente',
      apellidos: 'Apellidos',
      username: 'username',
      email: 'email',
      fechaNacimiento: new Date(),
      cp: 'cp',
    }
    console.log("Eliminar");
    this.cestaService.deleteLineaPedido(this.lineaPedido, this.cliente).subscribe((lineaPedido) => {
      this.lineaPedido = lineaPedido;
    });
  }
}
