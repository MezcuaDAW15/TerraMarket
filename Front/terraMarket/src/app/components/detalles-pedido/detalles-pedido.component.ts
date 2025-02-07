import { Component, Input, OnInit } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { Pedido } from '../../models/pedido';
import {ActivatedRoute, Router} from '@angular/router';
import { PedidoServiceService } from '../../services/pedido-service.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-detalles-pedido',
  standalone: true,
  imports: [BackComponent],
  templateUrl: './detalles-pedido.component.html',
  styleUrl: './detalles-pedido.component.scss'
})
export class DetallesPedidoComponent implements OnInit {
  rowData!: Pedido;
  private suscripcion: Subscription = new Subscription();

  constructor(private route: ActivatedRoute, private router: Router, private pedidoService:PedidoServiceService) { }

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
    });
  }
}
