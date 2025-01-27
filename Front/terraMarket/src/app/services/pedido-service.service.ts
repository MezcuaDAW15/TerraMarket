import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pedido } from '../models/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoServiceService {

  private url = `http://localhost:8888/ws/pedidos/clientes/1/pedidos`;

  constructor(private httpClient: HttpClient) { }

  findAllByCliente():Observable<Pedido[]>{
    return this.httpClient.get<Pedido[]>(this.url)
  }
}
