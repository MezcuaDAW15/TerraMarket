import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { BackComponent } from "../back/back.component";
import { PedidoServiceService } from '../../services/pedido-service.service';
import { Pedido } from '../../models/pedido';

interface Column {
    field: string;
    header: string;
}

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [TableModule, CommonModule, BackComponent],
  templateUrl: './pedidos.component.html',
  styleUrl: './pedidos.component.scss'
})

export class PedidosComponent implements OnInit{

  pedidos:Pedido[]= [];
  cols!: Column[];

  constructor(private pedidoService: PedidoServiceService){}

  ngOnInit(): void {
      this.mostrarPedidos()

      this.cols = [
        { field: 'id', header: 'Pedido' },
        { field: 'fechaPedido', header: 'Fecha Pedido' },
        { field: 'estado.estado', header: 'Estado' },
        { field: 'fechaEntrega', header: 'Fecha Recogida' },
        { field: `importe`, header: 'Total €' }
    ];
  }

  mostrarPedidos():void{

    this.pedidoService.findAllByCliente().subscribe((data)=>{
      this.pedidos = data;
      this.pedidos = this.pedidos.map(element =>({
          ...element,
          'estado.estado': element.estado.estado
      }))
      console.log(this.pedidos)
    })
  }

  pintarEstado(estado:string){
    if (estado != undefined) {
      //alert(estado);
    }
    switch(estado){
      case 'Pendiente': return 'etiqueta-estado-pendiente';
      case 'Recogido': return 'etiqueta-estado-recogido';
      case 'Cancelado': return 'etiqueta-estado-cancelado';
      default: return ''
    }
  }

}
