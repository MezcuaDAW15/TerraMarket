import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { BehaviorSubject, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private usuarioActual = new BehaviorSubject<any>(null);
  private url = `http://localhost:8888/ws/clientes`;

  constructor(private httpClient: HttpClient) {}

  login(cliente: Cliente):Observable<Cliente>{
    console.log('cliente servicio --> ' + JSON.stringify(cliente));
    return this.httpClient.post<Cliente>(`${this.url}/login`, cliente);
  }
  
  guardarSesion(cliente:Cliente){
    localStorage.setItem('cliente', JSON.stringify(cliente));
    console.log('session storage --> ' + localStorage.getItem('cliente'));
  }
  obtenerSesion(){
    const usuario = localStorage.getItem('cliente');
    if (usuario){
      this.usuarioActual.next(JSON.parse(usuario))
    }
    return this.usuarioActual.value;
  }

  findById(id:number):Observable<Cliente>{
    return this.httpClient.get<Cliente>(`${this.url}/${id}`);
  }

  updateCliente(cliente: Cliente):Observable<Cliente>{
    return this.httpClient.put<Cliente>(`${this.url}`,cliente);
  }
}
