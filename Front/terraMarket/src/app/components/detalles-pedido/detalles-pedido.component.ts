//import { MetodoPago } from './../../models/metodoPago';
import { Component, Input, OnInit } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { Pedido } from '../../models/pedido';
import { ActivatedRoute, Router } from '@angular/router';
import { PedidoServiceService } from '../../services/pedido-service.service';
import { Subscription } from 'rxjs';
import { CommonModule } from '@angular/common';
import { CardLineapedidoComponent } from "./components/card-lineapedido/card-lineapedido.component";



@Component({
  selector: 'app-detalles-pedido',
  standalone: true,
  imports: [BackComponent, CommonModule, CardLineapedidoComponent],
  templateUrl: './detalles-pedido.component.html',
  styleUrl: './detalles-pedido.component.scss'
})
export class DetallesPedidoComponent implements OnInit {
  rowData!: Pedido;
  idUsuario: number | null = null;
  //subdividir objeto

  private suscripcion: Subscription = new Subscription();

  constructor(private route: ActivatedRoute, private router: Router, private pedidoService: PedidoServiceService) { }

  getFormattedAddress(): string {
    if (!this.rowData?.puntoRecogida?.direccion) return '';

    const { calle, numero, piso, puerta, cp, ciudad, provincia } = this.rowData.puntoRecogida.direccion;

    let address = `${calle} ${numero}`;
    if (piso) address += `, Piso ${piso}`;
    if (puerta) address += `, Puerta ${puerta}`;
    address += `, ${cp} ${ciudad}`;

    return address;
  }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.idUsuario = this.pedidoService.getId();
    if (id) {
      this.pedidoService.findById(this.idUsuario!,id).subscribe({
        next: (data) => {
          this.rowData = data;
          console.log(this.rowData)
        }
      });
    }
  }

  pintarEstado(estado: string) {
    switch (estado) {
      case 'Pendiente': return 'etiqueta-estado-pendiente';
      case 'Recogido': return 'etiqueta-estado-recogido';
      case 'Cancelado': return 'etiqueta-estado-cancelado';
      default: return ''
    }
  };
}

