import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { BackComponent } from "../back/back.component";
import { PedidoServiceService } from '../../services/pedido-service.service';
import { Pedido } from '../../models/pedido';

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [TableModule, CommonModule, BackComponent],
  templateUrl: './pedidos.component.html',
  styleUrl: './pedidos.component.scss'
})

export class PedidosComponent implements OnInit{

  pedidos:Pedido[]= [];

  constructor(private pedidoService: PedidoServiceService){}

  ngOnInit(): void {
    this.mostrarPedidos()
  }

  mostrarPedidos():void{
    this.pedidoService.findAllByCliente().subscribe((data)=>{
      this.pedidos = data;
      console.log(this.pedidos)
    })
  }

    // products!: Product[];

    // cols!: Column[];

    // constructor(private productService: ProductService) {}

    // ngOnInit() {
    //     this.productService.getProductsMini().then((data) => {
    //         this.products = data;
    //     });

    //     this.cols = [
    //         { field: 'code', header: 'Code' },
    //         { field: 'name', header: 'Name' },
    //         { field: 'category', header: 'Category' },
    //         { field: 'quantity', header: 'Quantity' }
    //     ];
    // }
}
