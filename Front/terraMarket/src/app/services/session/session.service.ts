import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Cliente } from '../../models/cliente';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  private usuarioActual = new BehaviorSubject<any>(null);
  public usuario$ = this.usuarioActual.asObservable();

  private mercadoActual = new BehaviorSubject<any>(null);
  public mercado$ = this.mercadoActual.asObservable();

  constructor() {
    // const usuarioGuardado = localStorage.getItem('usuario');
    // console.log("-----------------------");
    // if (usuarioGuardado) {
    //   this.usuarioActual.next(JSON.parse(usuarioGuardado));
    // }
    // const mercadoGuardado = localStorage.getItem('mercado');
    // if (mercadoGuardado) {
    //   this.mercadoActual.next(JSON.parse(mercadoGuardado));
    // }
  }

  iniciarSesion(usuario: Cliente): void {
    console.log('SessionService -- iniciarSesion');



    localStorage.setItem('usuario', JSON.stringify(usuario));
    this.usuarioActual.next(usuario);
  }

  cerrarSesion(): void {
    console.log('SessionService -- cerrarSesion');
    localStorage.removeItem('usuario');
    this.usuarioActual.next(null);
  }

  obtenerUsuario(): any {
    console.log('SessionService -- obtenerUsuario');
    const usuario = localStorage.getItem('usuario');
    if (usuario) {
      this.usuarioActual.next(JSON.parse(usuario));
    }
    return this.usuarioActual.value;
  }

  setUsuario(usuario: Cliente) {
    this.usuarioActual.next(usuario);
  }
}
