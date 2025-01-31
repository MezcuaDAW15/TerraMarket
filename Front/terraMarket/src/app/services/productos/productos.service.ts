import { Producto } from '../../models/producto';
import { CategoriaP } from '../../models/categoriaP';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
  private baseUrl = `http://localhost:8888/ws/productos/`;

  constructor(private httpClient: HttpClient) { }

  findByCategories(categories: CategoriaP[]): Observable<Producto[]> {
    const categoryIds = categories.map(cat => cat.id).join(',');

    const url = `${this.baseUrl}buscarPorCategorias?categories=${categoryIds}`;

    return this.httpClient.get<Producto[]>(url);
  }
}
