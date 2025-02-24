import { Cliente } from './../../models/cliente';
import { CestaService } from './../../services/cesta/cesta.service';
import { Component, OnInit } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { CestaListComponent } from "./components/cesta-list/cesta-list.component";
import { Pedido } from '../../models/pedido';
import { ResumenComponent } from "./components/resumen/resumen.component";
import { SessionService } from '../../services/session/session.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cesta',
  standalone: true,
  imports: [BackComponent, CestaListComponent, ResumenComponent, CommonModule],
  templateUrl: './cesta.component.html',
  styleUrl: './cesta.component.scss'
})
export class CestaComponent implements OnInit {
  constructor(
    private cestaService: CestaService,
    private sessionService: SessionService,

  ) { }

  cesta: Pedido | null = null;
  cliente: Cliente | null = null;

  findCesta() {
    if (this.cliente) {
      console.log(this.cliente.id);
      this.cestaService.findPedidoPendiente(this.cliente).subscribe((data) => {
        this.cesta = data;
      });

    }


  }

  ngOnInit(): void {
    this.cliente = this.sessionService.obtenerUsuario();
    if (this.cliente) {
      this.findCesta();

    }
    console.log(this.cesta);
    console.log(this.cesta?.lineaPedido);

  }

}
