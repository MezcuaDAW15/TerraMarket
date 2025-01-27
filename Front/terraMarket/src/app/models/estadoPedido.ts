import { Pedido } from "./pedido";

export interface EstadoPedido {
    id: number;
    estado: string;
    listaPedidos: Pedido[];
    
    
}