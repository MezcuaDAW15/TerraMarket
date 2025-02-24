import { Component, Input, OnInit } from '@angular/core';
import { Tienda } from '../../models/tienda';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { TiendasService } from '../../services/tiendas/tiendas.service';
import { RatingModule } from 'primeng/rating';
import { ValoracionesService } from '../../services/valoraciones/valoraciones.service';
import { Valoracion } from '../../models/valoracion';
import { FormsModule } from '@angular/forms';
import { CarouselModule } from 'primeng/carousel';
import { ListaProductosComponent } from './components/lista-productos/lista-productos.component';

@Component({
  selector: 'app-tienda-view',
  standalone: true,
  imports: [
    CommonModule,
    RatingModule,
    FormsModule,
    CarouselModule,
    ListaProductosComponent,
  ],
  templateUrl: './tienda-view.component.html',
  styleUrl: './tienda-view.component.scss',
})
export class TiendaViewComponent implements OnInit {
  @Input() tienda: Tienda | null = null;
  imagenUrl: string | null = null;
  logoUrl: string | null = null;
  valoracioMedia!: number | null;
  valoraciones!: Valoracion[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tiendaService: TiendasService,
    private valoracionService: ValoracionesService
  ) {}

  ngOnInit(): void {
    //const routerMap = new Map<number, string>();
    //Crear servicio que devuelva el map de rutas

    const idMercado = Number(this.route.snapshot.paramMap.get('id'));
    const idTienda = Number(this.route.snapshot.paramMap.get('idTienda'));

    console.log('id', this.route.snapshot.paramMap.get('id'));
    console.log('tienda', this.route.snapshot.paramMap.get('idTienda'));

    if (
      !isNaN(idMercado) &&
      idMercado > 0 &&
      !isNaN(idTienda) &&
      idTienda > 0
    ) {
      // Solo llama al servicio si el ID es válido
      this.tiendaService.findById(idMercado, idTienda).subscribe({
        next: (data) => {
          this.tienda = data;
          this.valoracionService.findByTienda(this.tienda.id).subscribe({
            next: (valoraciones) => {
              this.valoraciones = valoraciones;
              this.calcularMediaPuntuacion();
            },
            error: (error) => {
              console.error('Error al cargar valoraciones:', error);
            },
          });
        },
        error: (error) => {
          console.error('Error al cargar la tienda:', error);
        },
      });
    } else {
      console.error('IDs no válidos:', idMercado, idTienda);
    }
    console.log('Tienda: ', this.tienda);
    console.log('Valoraciones: ', this.valoraciones);

    if (this.tienda?.imagen) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.tienda.imagen;
    }

    if (this.tienda?.logo) {
      this.logoUrl = 'data:image/jpeg;base64,' + this.tienda.logo;
    }
  }

  getFormattedAddress(): string {
    if (!this.tienda?.direccion) return '';

    const { calle, numero, piso, puerta, cp, ciudad, provincia } =
      this.tienda.direccion;

    let address = `${calle} ${numero}`;
    if (piso) address += `, Piso ${piso}`;
    if (puerta) address += `, Puerta ${puerta}`;
    address += `, ${cp} ${ciudad}, ${provincia}`;

    return address;
  }

  calcularMediaPuntuacion(): void {
    if (this.valoraciones.length > 0) {
      const sumaPuntuaciones = this.valoraciones.reduce(
        (sum, val) => sum + val.puntuacion,
        0
      );
      this.valoracioMedia = Math.round(
        sumaPuntuaciones / this.valoraciones.length
      );
      console.log('valoracion: ', this.valoracioMedia);
    } else {
      this.valoracioMedia = 0;
    }
  }
}
