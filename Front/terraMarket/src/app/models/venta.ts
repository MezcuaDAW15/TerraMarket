import { Tienda } from "./tienda";

export interface Venta {
  id: number;
  producto: Producto;
  tienda: Tienda;
  fechaVenta: Date;
  precioVenta: number;
  stock: number;
  precioKg: number;
  descuento: number;
  descripcion: string;
  activo: boolean;

}
