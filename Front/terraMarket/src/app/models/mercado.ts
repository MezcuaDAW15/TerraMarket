import { Direccion } from './direccion';

export interface Mercado {
  id: number;
  nombre: string;
  email: string;
  direccionF: string;
  telefono: string;
  activo: boolean;
  imagen: string;
  direccion: Direccion;
  listaTiendas: any[];
}
