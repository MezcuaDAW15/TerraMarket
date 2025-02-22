import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RutasService {

  private baseUrl = `http://localhost:8888/ws/`;


  constructor(private httpClient: HttpClient) { }

  getRutas(): Observable<Map<number, string>> {
    return this.httpClient.get<Map<number, string>>(`${this.baseUrl}market/rutas`);
  }
}
