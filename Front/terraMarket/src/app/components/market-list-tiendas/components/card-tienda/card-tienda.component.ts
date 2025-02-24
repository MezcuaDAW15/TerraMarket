import { Component, Input, OnInit } from '@angular/core';
import { Tienda } from '../../../../models/tienda';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { TiendasService } from '../../../../services/tiendas/tiendas.service';
import { Mercado } from '../../../../models/mercado';

@Component({
  selector: 'app-card-tienda',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-tienda.component.html',
  styleUrl: './card-tienda.component.scss',
})
export class CardTiendaComponent implements OnInit {
  @Input() tienda: Tienda | null = null;
  @Input() mercado: Mercado | null = null;
  imagenUrl: string | null = null;

  constructor(private router: Router, private tiendasService: TiendasService) {}

  ngOnInit(): void {
    console.log(this.tienda);
    if (this.tienda?.imagen) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.tienda.imagen;
    }
  }

  irATienda(tienda: Tienda | null): void {
    if (!tienda) {
      console.error('Error: LineaPedido es null');
      return;
    }
    const datosTienda = {
      tienda: tienda,
    };
    console.log(tienda);
    // Guardar los datos en el servicio
    this.tiendasService.setDatosTienda(datosTienda);

    // Redirigir a la pantalla de valoración
    this.router.navigate([this.mercado?.id + '/tiendas/' + this.tienda?.id]);
  }
}
