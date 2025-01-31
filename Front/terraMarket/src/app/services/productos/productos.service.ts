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
    // Crear un objeto FormData
    let params = new FormData();

    // Agregar cada categoría al FormData
    categories.forEach((categoria, index) => {
        params.append(`categorias[${index}]`, categoria.id.toString());
    });

    // URL del endpoint (sin parámetros de consulta)
    const url = `${this.baseUrl}buscarPorCategorias`;

    // Realizar la solicitud POST con FormData
    return this.httpClient.post<Producto[]>(url, params);
}
}
