import { Component } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { DatosPersonalesComponent } from './components/datos-personales/datos-personales.component';
import { ResumenPedidoComponent } from './components/resumen-pedido/resumen-pedido.component';
import { ElegirMetodoPagoComponent } from "./components/elegir-metodo-pago/elegir-metodo-pago.component";
import { ElegirPuntoRecogidaComponent } from "./components/elegir-punto-recogida/elegir-punto-recogida.component";

@Component({
  selector: 'app-realizar-pedido',
  standalone: true,
  imports: [BackComponent, DatosPersonalesComponent, ResumenPedidoComponent, ElegirMetodoPagoComponent, ElegirPuntoRecogidaComponent],
  templateUrl: './realizar-pedido.component.html',
  styleUrl: './realizar-pedido.component.scss'
})
export class RealizarPedidoComponent {

}
