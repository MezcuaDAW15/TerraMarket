export interface Cliente {
  id: number;
  nombre: string;
  apellidos: string;
  username: string;
  fechaNacimiento: Date;
  email: string;
  contrasena: string;
  cp: string;
  activo: boolean;
  listaPedidos: any[];
}

