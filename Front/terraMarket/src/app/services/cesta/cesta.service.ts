import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { Pedido } from '../../models/pedido';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CestaService {

  private baseUrl = `http://localhost:8888/ws/pedidos`;

  constructor(private httpClient: HttpClient) { }

  findPedidoPendiente(cliente: Cliente) {
    cliente.id = 1;
    const url = `${this.baseUrl}/buscarPedidoPendiente?idCliente=${cliente.id}`;
    return this.httpClient.get<Pedido>(url);

  }
}
