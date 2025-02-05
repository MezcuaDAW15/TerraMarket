import { Cliente } from './../../models/cliente';
import { CestaService } from './../../services/cesta/cesta.service';
import { Component } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { CestaListComponent } from "./components/cesta-list/cesta-list.component";
import { Pedido } from '../../models/pedido';

@Component({
  selector: 'app-cesta',
  standalone: true,
  imports: [BackComponent, CestaListComponent],
  templateUrl: './cesta.component.html',
  styleUrl: './cesta.component.scss'
})
export class CestaComponent {
  constructor(
    private cestaService: CestaService
  ) { }
  cesta: Pedido | null = null;
  cliente: Cliente | null = null;

  findCesta(){
    this.cliente = {
      id: 1,
      nombre: 'Cliente',
      apellidos: 'Apellidos',
      username: 'username',
      email: 'email',
      fechaNacimiento: new Date(),
      cp: 'cp',

    };
    this.cestaService.findPedidoPendiente(this.cliente).subscribe((data) => {
      this.cesta = data;
    });

    return this.cesta?.lineaPedido;
  }



}
