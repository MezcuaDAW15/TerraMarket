export interface Pedido {
    id: number;
    categoria: number;
    nombre: string;
    descripcion: string | null;
    precio: number;
    imagen: string;
    vendedor: number;
    estado: 'D' | 'V';
}