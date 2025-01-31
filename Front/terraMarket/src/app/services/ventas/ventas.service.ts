import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Venta } from '../../models/venta';
import { Producto } from '../../models/producto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VentasService {
  private baseUrl = `http://localhost:8888/ws/productos/`;

  constructor(private httpClient: HttpClient) { }

  findAllByProducto(producto: Producto): Observable<Venta[]> {
    const url = `${this.baseUrl}buscarPorProducto?productoId=${producto.id}`;

    return this.httpClient.get<Venta[]>(url);

  }
}
