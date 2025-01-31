//import { MetodoPago } from './../../models/metodoPago';
import { Component, Input, OnInit } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { Pedido } from '../../models/pedido';
import {ActivatedRoute, Router} from '@angular/router';
import { PedidoServiceService } from '../../services/pedido-service.service';
import { Subscription } from 'rxjs';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-detalles-pedido',
  standalone: true,
  imports: [BackComponent, CommonModule],
  templateUrl: './detalles-pedido.component.html',
  styleUrl: './detalles-pedido.component.scss'
})
export class DetallesPedidoComponent implements OnInit {
  rowData!: Pedido;
  //subdividir objeto

  private suscripcion: Subscription = new Subscription();

  constructor(private route: ActivatedRoute, private router: Router, private pedidoService:PedidoServiceService) { }

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
    // this.route.paramMap.subscribe(() => {
    //   const navigation = this.router.getCurrentNavigation();
    //   if (navigation?.extras.state) {
    //     this.rowData = navigation.extras.state['rowData'];
    //   }
    //   console.log(this.rowData);
    // });

    this.suscripcion = this.pedidoService.pedidoActual$.subscribe(data => {
      this.rowData = data;
      console.log("Pedido component Linea pedido:", this.rowData?.listaLineasPedido);
      
      //console.log(this.rowData.metodoPago.nombre)
    });

    
  }
}
