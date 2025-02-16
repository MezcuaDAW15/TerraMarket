import { CategoriaP } from './categoriaP';
export interface CategoriaT {
  id: number;
  nombre: string;
  descripcion: string;
  icono: string;
  listaCategoriaP: CategoriaP[];
}
/*
 private Long id;
    private String nombre;
    private String descripcion;
    private String icono;
*/
