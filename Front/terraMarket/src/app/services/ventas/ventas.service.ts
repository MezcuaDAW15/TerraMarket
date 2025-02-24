import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Venta } from '../../models/venta';
import { Producto } from '../../models/producto';
import { Observable } from 'rxjs';
import { Mercado } from '../../models/mercado';
import { CategoriaP } from '../../models/categoriaP';
import { Tienda } from '../../models/tienda';

@Injectable({
  providedIn: 'root',
})
export class VentasService {
  private baseUrl = `http://localhost:8888/ws/ventas`;

  constructor(private httpClient: HttpClient) {}

  findAllByProducto(producto: Producto, mercado: Mercado): Observable<Venta[]> {
    const url = `${this.baseUrl}buscarPorProducto?productoId=${producto.id}`;

    return this.httpClient.get<Venta[]>(url);
  }
  findVentasByProducto(idProducto: Number, idMercado: Number): Observable<Venta[]> {
    const url = `${this.baseUrl}/buscarPorProducto?idProducto=${idProducto}&idMercado=${idMercado}`;

    return this.httpClient.get<Venta[]>(url);

  }

  findByVentasProductos(categories: CategoriaP[], mercado: Mercado) {
    const url = `${this.baseUrl}?mercado=${mercado.id}&categorias=${categories
      .map((c) => c.id)
      .join(',')}`;

    return this.httpClient.get<Venta[]>(url);
  }

  findByVentasTienda(categories: CategoriaP[], tienda: Tienda) {
    const url = `${this.baseUrl}/tienda?tienda=${
      tienda.id
    }&categorias=${categories.map((c) => c.id).join(',')}`;

    return this.httpClient.get<Venta[]>(url);
  }
}
