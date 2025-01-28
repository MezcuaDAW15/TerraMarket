import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { BackComponent } from "../back/back.component";
import { PedidoServiceService } from '../../services/pedido-service.service';
import { Pedido } from '../../models/pedido';
import { RouterLink } from '@angular/router';


interface Column {
    field: string;
    header: string;
}

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [TableModule, CommonModule, BackComponent,CommonModule, RouterLink],
  templateUrl: './pedidos.component.html',
  styleUrl: './pedidos.component.scss',
  encapsulation: ViewEncapsulation.None
})

export class PedidosComponent implements OnInit{

  pedidos:Pedido[]= [];
  cols!: Column[];
  idpedido: number = 0;

  constructor(private pedidoService: PedidoServiceService){}

  ngOnInit(): void {
      this.mostrarPedidos()

      this.cols = [
        { field: 'id', header: 'Pedido' },
        { field: 'fechaPedido', header: 'Fecha Pedido' },
        { field: 'estado.estado', header: 'Estado' },
        { field: 'fechaEntrega', header: 'Fecha Recogida' },
        { field: 'importe', header: 'Total' },
        { field: 'detalles', header: 'Detalles' }



    ];
    console.log(this.cols);

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
    
    switch(estado){
      case 'Pendiente': return 'etiqueta-estado-pendiente';
      case 'Recogido': return 'etiqueta-estado-recogido';
      case 'Cancelado': return 'etiqueta-estado-cancelado';
      default: return ''
    }
  }

  verDetalles(rowData: any){
    console.log(rowData.id)
  }

}
