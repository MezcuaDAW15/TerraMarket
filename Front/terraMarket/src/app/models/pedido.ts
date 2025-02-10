import { Cliente } from "./cliente";
import { EstadoPedido } from "./estadoPedido";
import { LineaPedido } from "./lineaPedido";
import { MetodoPago } from "./metodoPago";
import { PuntoRecogida } from "./puntoRecogida";

export interface Pedido {
  id: number;
  cliente: Cliente;
  lineaPedido: LineaPedido[];
  metodoPago: MetodoPago;
  puntoRecogida: PuntoRecogida;
  fechaPedido: Date;
  fechaCompra: Date;
  fechaEntrega: Date;
  fechaMaxRecogida: Date;
  fechaFactura: Date;
  numFactura: number;
  estado: EstadoPedido;
  importe: number;

}
