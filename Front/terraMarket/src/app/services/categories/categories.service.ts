import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CategoriaT } from '../../models/categoriaT';


@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  private baseUrl = `http://localhost:8888/ws/`;


  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<CategoriaT[]> {
    return this.httpClient.get<CategoriaT[]>(`${this.baseUrl}categorias`);
  }
}
