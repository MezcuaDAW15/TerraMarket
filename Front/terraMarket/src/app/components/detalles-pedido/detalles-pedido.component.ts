import { Component } from '@angular/core';
import { BackComponent } from '../back/back.component';


@Component({
  selector: 'app-detalles-pedido',
  standalone: true,
  imports: [BackComponent],
  templateUrl: './detalles-pedido.component.html',
  styleUrl: './detalles-pedido.component.scss'
})
export class DetallesPedidoComponent {

}
