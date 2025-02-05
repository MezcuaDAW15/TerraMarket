import { Component } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { PedidoDatospersonalesComponent } from './components/pedido-datospersonales/pedido-datospersonales.component';

@Component({
  selector: 'app-realizar-pedido',
  standalone: true,
  imports: [BackComponent, PedidoDatospersonalesComponent],
  templateUrl: './realizar-pedido.component.html',
  styleUrl: './realizar-pedido.component.scss'
})
export class RealizarPedidoComponent {

}
