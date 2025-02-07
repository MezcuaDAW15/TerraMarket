import { Pedido } from "./pedido";

export interface MetodoPago {
    id: number;
    nombre: string;
    descripcion: string;
    listaPedidos: Pedido[];
    
}