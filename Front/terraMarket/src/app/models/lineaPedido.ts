import { Pedido } from "./pedido";
import { Venta } from "./venta";

export interface LineaPedido {
  id?: number;
  cantidad: number;
  fecha: Date;
  venta: Venta;
  pedido: Pedido;
}
/*    private Long id;

    private VentaDTO ventaDTO;
    private PedidoDTO pedidoDTO;
    private int cantidad;
    private Date fecha; */
