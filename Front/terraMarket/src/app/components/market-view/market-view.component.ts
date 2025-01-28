import { Component, OnInit } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { BannerComponent } from "../banner/banner.component";
import { ListComponent } from "../list/list.component";
import { Mercado } from '../../models/mercado';
import { RouterLink } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { MarketService } from '../../services/markets/market.service';



@Component({
  selector: 'app-market-view',
  standalone: true,
  imports: [BackComponent, BannerComponent, ListComponent],
  templateUrl: './market-view.component.html',
  styleUrl: './market-view.component.scss'
})
export class MarketViewComponent implements OnInit {

  mercado: Mercado | null = null; // Datos del mercado
  errorMessage: string = ''; // Para manejar errores

  constructor(
    private route: ActivatedRoute,
    private marketService: MarketService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    if (!isNaN(id) && id > 0) {
      // Solo llama al servicio si el ID es válido
      this.marketService.findById(id).subscribe({
        next: (data) => {
          this.mercado = data;
        },
        error: (error) => {
          console.error('Error al cargar el mercado:', error);
          this.errorMessage = 'No se pudo cargar la información del mercado.';
        }
      });
    } else {
      this.errorMessage = 'ID de mercado no válido.';
      console.error('ID de mercado no válido:', id);
    }
  }
}
