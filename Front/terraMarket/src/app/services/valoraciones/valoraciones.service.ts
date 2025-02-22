import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

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
}
