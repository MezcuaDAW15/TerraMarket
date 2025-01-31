import { CategoriaP } from './../../models/categoriaP';
import { Component, OnInit } from '@angular/core';
import { ChipsComponent } from "./components/chips/chips.component";
import { CategoriaT } from '../../models/categoriaT';
import { CommonModule } from '@angular/common';
import { CategoriesService } from '../../services/categories/categories.service';

@Component({
  selector: 'app-filtros',
  standalone: true,
  imports: [ChipsComponent, CommonModule],
  templateUrl: './filtros.component.html',
  styleUrl: './filtros.component.scss'
})
export class FiltrosComponent implements OnInit {
  categoriasT: CategoriaT[] = [];

  constructor(
    private categoriesService: CategoriesService
  ) { }

  ngOnInit() {
    this.categoriesService.findAll().subscribe((data) => {
      this.categoriasT = data;
    })
  }
  trackByFn(index: number, item: any) {
    return item.id;
  }
}




// this.categoriasT = [
//   {
//     id: 1,
//     nombre: "Aves y derivados",
//     descripcion: "Productos de aves como pollo, pavo, pato y huevos.",
//     icono: "aves.png",
//     listaCategoriasPDTO: [
//       { id: 1, nombre: "Pollo", descripcion: "Entero, en piezas, alitas, muslos, etc." },
//       { id: 2, nombre: "Pavo", descripcion: "Fresco, congelado, en filetes o molido." },
//       { id: 3, nombre: "Huevos", descripcion: "Blancos, rojos, orgánicos, de codorniz." }
//     ]
//   },
//   {
//     id: 2,
//     nombre: "Carnes Rojas",
//     descripcion: "Variedad de carnes rojas como res, cerdo y cordero.",
//     icono: "carnes.png",
//     listaCategoriasPDTO: [
//       { id: 4, nombre: "Res", descripcion: "Cortes como lomo, costilla, filete y molida." },
//       { id: 5, nombre: "Cerdo", descripcion: "Chuletas, costillas, pierna y tocino." },
//       { id: 6, nombre: "Cordero", descripcion: "Pierna, costillas, paleta y chuletas." }
//     ]
//   },
//   {
//     id: 3,
//     nombre: "Pescados y Mariscos",
//     descripcion: "Productos frescos y congelados del mar y agua dulce.",
//     icono: "pescados.png",
//     listaCategoriasPDTO: [
//       { id: 7, nombre: "Pescado Blanco", descripcion: "Tilapia, merluza, bacalao y más." },
//       { id: 8, nombre: "Pescado Azul", descripcion: "Atún, salmón, sardina y caballa." },
//       { id: 9, nombre: "Mariscos", descripcion: "Camarón, langosta, mejillones y almejas." }
//     ]
//   },
//   {
//     id: 4,
//     nombre: "Lácteos y Derivados",
//     descripcion: "Leche, quesos y otros productos lácteos.",
//     icono: "lacteos.png",
//     listaCategoriasPDTO: [
//       { id: 10, nombre: "Leche", descripcion: "Entera, descremada, deslactosada y vegetal." },
//       { id: 11, nombre: "Quesos", descripcion: "Fresco, manchego, mozzarella, cheddar." },
//       { id: 12, nombre: "Yogures", descripcion: "Natural, griego, con frutas y bebible." }
//     ]
//   },
//   {
//     id: 5,
//     nombre: "Frutas y Verduras",
//     descripcion: "Variedad de frutas y verduras frescas.",
//     icono: "frutas.png",
//     listaCategoriasPDTO: [
//       { id: 13, nombre: "Frutas", descripcion: "Manzanas, plátanos, uvas, fresas y más." },
//       { id: 14, nombre: "Verduras", descripcion: "Lechuga, zanahoria, tomate, espinaca." },
//       { id: 15, nombre: "Tubérculos", descripcion: "Papa, yuca, camote y zanahoria." }
//     ]
//   }
// ];
