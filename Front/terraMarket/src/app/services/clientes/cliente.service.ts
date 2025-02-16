import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { Observable } from 'rxjs';
import { Pedido } from '../../models/pedido';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private url = `http://localhost:8888/ws/clientes`;

  constructor(private httpClient: HttpClient) {}

  login(cliente: Cliente):Observable<number>{
    
    console.log('cliente servicio --> ' + JSON.stringify(cliente));
    return this.httpClient.post<number>(`${this.url}/login`, cliente)
  }
  
}
