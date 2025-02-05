import { Component } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { DatosPersonalesComponent } from './components/datos-personales/datos-personales.component';

@Component({
  selector: 'app-realizar-pedido',
  standalone: true,
  imports: [BackComponent, DatosPersonalesComponent],
  templateUrl: './realizar-pedido.component.html',
  styleUrl: './realizar-pedido.component.scss'
})
export class RealizarPedidoComponent {

}
