import { Mercado } from './../../models/mercado';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tienda } from '../../models/tienda';
import { Observable } from 'rxjs';
import { CategoriaT } from '../../models/categoriaT';

@Injectable({
  providedIn: 'root',
})
export class TiendasService {
  private baseUrl = `http://localhost:8888/ws/`;

  constructor(private httpClient: HttpClient) {}

  findAllByMercado(
    mercado: Mercado,
    categories: CategoriaT[]
  ): Observable<Tienda[]> {
    return this.httpClient.get<Tienda[]>(
      `${this.baseUrl}mercados/${mercado.id}/tiendas?categorias=${categories
        .map((c) => c.id)
        .join(',')}`
    );
  }

  findById(id: number, idTienda: number): Observable<Tienda> {
    return this.httpClient.get<Tienda>(
      `${this.baseUrl}mercados/${id}/tiendas/${idTienda}`
    );
  }
}
