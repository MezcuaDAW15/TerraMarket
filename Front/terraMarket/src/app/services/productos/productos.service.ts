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

  
}
