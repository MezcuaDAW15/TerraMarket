import { LineaPedido } from './../models/lineaPedido';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pedido } from '../models/pedido';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PedidoServiceService {

  private url = `http://localhost:8888/ws/clientes/1/pedidos`;

  constructor(private httpClient: HttpClient) { }

  findAllByCliente():Observable<Pedido[]>{
    return this.httpClient.get<Pedido[]>(this.url)
  }
  findById(id: number):Observable<Pedido>{
    return this.httpClient.get<Pedido>(`${this.url}/${id}`)
  }

  private pedidoSource = new BehaviorSubject<Pedido>({} as Pedido); // inicializamos el BehaviorSubject con un objeto vacío
  pedidoActual$ = this.pedidoSource.asObservable(); // creamos un observable a partir del BehaviorSubject


  // método para cambiar el valor del BehaviorSubject
  pasarPedido(pedido: Pedido){
    this.pedidoSource.next(pedido);
    //console.log("lista lineas pedido" + pedido.listaLineasPedido)
  }
}
