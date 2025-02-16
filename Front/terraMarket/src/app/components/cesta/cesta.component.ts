import { Cliente } from './../../models/cliente';
import { CestaService } from './../../services/cesta/cesta.service';
import { Component, OnInit } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { CestaListComponent } from "./components/cesta-list/cesta-list.component";
import { Pedido } from '../../models/pedido';
import { ResumenComponent } from "./components/resumen/resumen.component";

@Component({
  selector: 'app-cesta',
  standalone: true,
  imports: [BackComponent, CestaListComponent, ResumenComponent],
  templateUrl: './cesta.component.html',
  styleUrl: './cesta.component.scss'
})
export class CestaComponent implements OnInit {
  constructor(
    private cestaService: CestaService
  ) { }

  cesta: Pedido | null = null;
  cliente: Cliente | null = null;

  findCesta() {
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
  }

  ngOnInit(): void {
    this.findCesta();
    console.log(this.cesta);
    console.log(this.cesta?.lineaPedido);

  }

}
