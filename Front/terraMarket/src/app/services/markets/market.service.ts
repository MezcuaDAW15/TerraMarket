import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Mercado } from '../../models/mercado';

@Injectable({
  providedIn: 'root',
})
export class MarketService {
  private baseUrl = `http://localhost:8888/ws/market/`;

  constructor(private httpClient: HttpClient) {}

  findAll(): Observable<Mercado[]> {
    return this.httpClient.get<Mercado[]>(this.baseUrl);
  }

  findById(id: number): Observable<Mercado> {
    return this.httpClient.get<Mercado>(`${this.baseUrl}${id}`).pipe(
      map((data: any) => {
        console.log(data);
        return data;
      })
    );
  }
}
