import { LineaPedido } from './../../models/lineaPedido';
import { SessionService } from './../../services/session/session.service';
import { FormsModule } from '@angular/forms';

import { Result } from './../../../../node_modules/read-package-json/node_modules/glob/dist/commonjs/glob.d';
import { VentasService } from './../../services/ventas/ventas.service';
import { Component, OnInit } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { on } from 'events';
import { ActivatedRoute, Router } from '@angular/router';
import { MarketService } from '../../services/markets/market.service';
import { RutasService } from '../../services/rutas/rutas.service';
import { ProductosService } from '../../services/productos/productos.service';
import { Producto } from '../../models/producto';
import { Venta } from '../../models/venta';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CestaService } from '../../services/cesta/cesta.service';

@Component({
  selector: 'app-product-view',
  standalone: true,
  imports: [BackComponent, CommonModule, FormsModule],
  templateUrl: './product-view.component.html',
  styleUrl: './product-view.component.scss'
})
export class ProductViewComponent implements OnInit {
  producto: Producto | null = null;
  ventas: Venta[] = [];
  imagenUrl: string | null = null;
  cantidad: number = 1;
  ventaSeleccionada: Venta | null = null;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productosService: ProductosService,
    private VentasService: VentasService,
    private rutaService: RutasService,
    private sessionService: SessionService,

    private cestaService: CestaService

  ) { }

  ngOnInit(): void {
    const routerMap = new Map<number, string>();

    this.rutaService.getRutasProductos().subscribe({
      next: (data) => {
        for (let key in data as { [key: string]: any }) {
          routerMap.set(Number(key), (data as { [key: string]: any })[key].toString());
        }
        console.log("Router Map:", routerMap);

        // Obtener el nombre del mercado desde la URL
        const nombreProducto = this.route.snapshot.paramMap.get('nombreProducto');
        console.log("Nombre en URL:", nombreProducto);

        if (nombreProducto) {
          // Buscar el ID correspondiente en routerMap
          const productoId = [...routerMap.entries()]
            .find(([id, name]) => name === nombreProducto)?.[0];

          if (productoId) {
            this.loadProducto(productoId);
          } else {
            console.error("Producto no encontrado:", nombreProducto);
          }
        } else {
          console.error("Nombre de mercado no válido en la URL.");
        }
      },
      error: (error) => {
        console.error("Error al cargar rutas:", error);
      }
    });


  }
  loadProducto(id: number): void {
    this.productosService.findAllByProductoId(id).subscribe({
      next: (data) => {
        this.producto = data;
        console.log("Producto cargado:", this.producto);
      },
      error: (error) => {
        console.error("Error al cargar el mercado:", error);
      }
    });
    if (this.producto?.imagen) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.producto.imagen;
    }

    if (this.producto) {
      this.VentasService.findVentasByProducto(this.producto.id, 3).subscribe({
        next: (data) => {
          this.ventas = data;
          console.log("Ventas cargadas:", this.ventas);
        },
        error: (error) => {
          console.error("Error al cargar ventas:", error);
        }
      });

    }
  }

  sumarCantidad(): void {
    this.cantidad++;
  }
  restarCantidad(): void {
    if (this.cantidad > 1) {
      this.cantidad--;
    }
  }
  anadirCesta(): void {
    if (this.ventaSeleccionada) {
      console.log('Venta seleccionada:', this.ventaSeleccionada);
      let lineaPedido: LineaPedido | null = null;
      this.cestaService.findPedidoPendiente(this.sessionService.obtenerUsuario()).subscribe({
        next: (pedido) => {
          lineaPedido = {
            id: undefined,
            cantidad: this.cantidad,
            venta: this.ventaSeleccionada!,
            fecha: new Date(),
            pedido: pedido
          };
        },
        error: (error) => {
          console.error("Error al obtener el pedido pendiente:", error);
        }

      });
    } else {
      console.log('Por favor, selecciona una tienda antes de añadir a la cesta.');
    }
  }

}
