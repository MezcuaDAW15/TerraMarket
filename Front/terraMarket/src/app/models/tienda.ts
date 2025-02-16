import { CategoriaT } from './categoriaT';
import { Mercado } from "./mercado";

export interface Tienda {
  id: number;
  nombre: string;
  logo: string;
  descripcion: string;
  imagen: string;
  activo: boolean;
  categoriaT: CategoriaT[];
}
/*    private Long id;
    private String nombre;
    private String logo;
    private String descripcion;
    private String imagen;
    private boolean activo;
    private MercadoDTO mercadoDTO;*/
