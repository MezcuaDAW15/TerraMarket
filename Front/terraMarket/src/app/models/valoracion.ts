import { Tienda } from './tienda';
import { Cliente } from './cliente';

export interface Valoracion {
  id: number;
  tienda: Tienda;
  cliente: Cliente;
  puntuacion: number;
  resena: string;
  fecha: string;
}
