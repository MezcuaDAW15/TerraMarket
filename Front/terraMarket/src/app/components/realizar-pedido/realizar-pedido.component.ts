import { Component } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { DatosPersonalesComponent } from './components/datos-personales/datos-personales.component';
import { ResumenPedidoComponent } from './components/resumen-pedido/resumen-pedido.component';
import { ElegirMetodoPagoComponent } from "./components/elegir-metodo-pago/elegir-metodo-pago.component";

@Component({
  selector: 'app-realizar-pedido',
  standalone: true,
  imports: [BackComponent, DatosPersonalesComponent, ResumenPedidoComponent, ElegirMetodoPagoComponent],
  templateUrl: './realizar-pedido.component.html',
  styleUrl: './realizar-pedido.component.scss'
})
export class RealizarPedidoComponent {

}
