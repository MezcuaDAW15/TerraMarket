import { Injectable } from '@angular/core';
import { Mercado } from '../models/mercado';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class MercadoServiceService {
  private url = `http://localhost:8888/ws/mercados`;

  constructor(private httpClient: HttpClient) {}

  // findAll(): Observable<Mercado[]> {
  //   return this.httpClient.get<Mercado[]>(this.url);
  // }
}
