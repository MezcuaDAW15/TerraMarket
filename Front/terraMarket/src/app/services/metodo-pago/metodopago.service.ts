import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MetodoPago } from '../../models/metodoPago';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MetodopagoService {

  private url = `http://localhost:8888/ws/metodospago`;

  constructor(private httpClient: HttpClient) { }

  findAll():Observable<MetodoPago[]>{
      return this.httpClient.get<MetodoPago[]>(this.url);
  }
  
}
