import { LineaPedido } from './../../models/lineaPedido';
import { SessionService } from './../../services/session/session.service';
import { FormsModule } from '@angular/forms';

import { VentasService } from './../../services/ventas/ventas.service';
import { Component, OnInit } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { ActivatedRoute, Router } from '@angular/router';
import { RutasService } from '../../services/rutas/rutas.service';
import { ProductosService } from '../../services/productos/productos.service';
import { Producto } from '../../models/producto';
import { Venta } from '../../models/venta';
import { CommonModule } from '@angular/common';
import { CestaService } from '../../services/cesta/cesta.service';
import { MarketService } from '../../services/markets/market.service';
import { Mercado } from '../../models/mercado';

@Component({
  selector: 'app-product-view',
  standalone: true,
  imports: [BackComponent, CommonModule, FormsModule],
  templateUrl: './product-view.component.html',
  styleUrl: './product-view.component.scss'
})
export class ProductViewComponent implements OnInit {
  producto: Producto | null = null;
  mercado: Mercado | null = null;
  ventas: Venta[] = [];
  imagenUrl: string | null = null;
  cantidad: number = 1;
  ventaSeleccionada: Number | null = null;
  routerMapMarket = new Map<number, string>();
  error: string | null = null;



  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productosService: ProductosService,
    private marketService: MarketService,
    private ventasService: VentasService,
    private rutaService: RutasService,
    private sessionService: SessionService,

    private cestaService: CestaService

  ) { }

  ngOnInit(): void {
    const routerMap = new Map<number, string>();


    this.rutaService.getRutas().subscribe({
      next: (data) => {
        for (let key in data as { [key: string]: any }) {
          this.routerMapMarket.set(Number(key), (data as { [key: string]: any })[key].toString());
        }
        console.log("Router Map:", this.routerMapMarket);

        // Obtener el nombre del mercado desde la URL
        const nombreMercado = this.route.snapshot.paramMap.get('nombreMercado');
        console.log("Nombre en URL:", nombreMercado);

        if (nombreMercado) {
          // Buscar el ID correspondiente en routerMap
          const mercadoId = [...this.routerMapMarket.entries()]
            .find(([id, name]) => name === nombreMercado)?.[0];

          if (mercadoId) {
            this.loadMarket(mercadoId);
          } else {
            console.error("Mercado no encontrado:", mercadoId);
          }
        } else {
          console.error("Nombre de mercado no válido en la URL.");
        }
      },
      error: (error) => {
        console.error("Error al cargar rutas:", error);
      }
    });

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
          console.error("Nombre de producto no válido en la URL.");
        }
      },
      error: (error) => {
        console.error("Error al cargar rutas:", error);
      }
    });
    console.log(this.ventas)






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

    if (this.producto && this.mercado) {
      console.log(this.producto, this.mercado);
      this.ventasService.findVentasByProducto(this.producto.id, this.mercado.id).subscribe({
        next: (data) => {
          this.ventas = data;
          console.log("Ventas cargadas:", this.ventas);
          if (this.ventas.length <= 0) {
            const ruta = this.routerMapMarket.get(this.mercado?.id!)
            console.log("Ruta: ", ruta);
            window.location.href = `/${ruta}`;
          }
        },
        error: (error) => {
          console.error("Error al cargar ventas:", error);
        }
      });

    }
  }

  loadMarket(id: number): void {
    this.marketService.findById(id).subscribe({
      next: (data) => {
        this.mercado = data;
        console.log("Mercado cargado:", this.mercado);
      },
      error: (error) => {
        console.error("Error al cargar el mercado:", error);
      }
    });
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
    let lineaPedido: LineaPedido | null = null;
    if (this.ventaSeleccionada) {
      console.log('Venta seleccionada:', this.ventaSeleccionada);
      console.log(this.ventas.find(v => v.id === Number(this.ventaSeleccionada)));

      this.cestaService.findPedidoPendiente(this.sessionService.obtenerUsuario()).subscribe({
        next: (pedido) => {
          lineaPedido = {
            id: undefined,
            cantidad: this.cantidad,
            venta: this.ventas.find(v => v.id === Number(this.ventaSeleccionada)) as Venta,
            fecha: new Date(),
            pedido: pedido
          };
          console.log("-------------------------")
          this.cestaService.addLineaPedido(lineaPedido!).subscribe({
            next: (data) => {
              console.log("Línea de pedido añadida:", data);
              this.router.navigate(['/cesta']);
            },
            error: (error) => {
              console.error("Error al añadir la línea de pedido:", error);

            }
          });
        },
        error: (error) => {
          console.error("Error al obtener el pedido pendiente:", error);
        }


      });
    } else {
      this.error = "Selecciona una tienda.";
    }



  }
  handleChange() {
    if (this.ventaSeleccionada) {
      this.error = null;
    }
  }
  formatNumber(value: number): string {
    if (value < 10) {
      return value.toFixed(2).replace(".", ",");
    }

    // Si el valor es mayor o igual a 10, formatea con ceros a la izquierda
    return value.toFixed(2).replace(".", ",").padStart(5, "0");
  }

}
