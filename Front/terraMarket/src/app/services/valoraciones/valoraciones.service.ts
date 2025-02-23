import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Valoracion } from '../../models/valoracion';

@Injectable({
  providedIn: 'root',
})
export class ValoracionesService {
  private datosValoracion = new BehaviorSubject<any>(null);
  datosValoracion$ = this.datosValoracion.asObservable();

  private url = 'http://localhost:8888/ws/valoraciones';

  constructor(private httpClient: HttpClient) {}

  setDatosValoracion(datos: any): void {
    this.datosValoracion.next(datos);
  }

  registrarValoracion(valoracionData: any): Observable<any> {
    return this.httpClient.post(this.url, valoracionData, {
      headers: { 'Content-Type': 'application/json' },
    });
  }

  findByTienda(idTienda: number): Observable<Valoracion[]> {
    return this.httpClient.get<Valoracion[]>(`${this.url}/tiendas/${idTienda}`);
  }
}
