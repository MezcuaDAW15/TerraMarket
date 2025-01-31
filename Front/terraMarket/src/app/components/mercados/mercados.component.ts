import { Component, OnInit } from '@angular/core';
import { Mercado } from '../../models/mercado';
import { MercadoServiceService } from '../../services/mercado-service.service';
import { CardMarketComponent } from '../card-market/card-market.component';

@Component({
  selector: 'app-mercados',
  standalone: true,
  imports: [CardMarketComponent],
  templateUrl: './mercados.component.html',
  styleUrl: './mercados.component.scss',
})
export class MercadosComponent implements OnInit {
  mercados: Mercado[] = [];

  constructor(private mercadoService: MercadoServiceService) {}
  ngOnInit(): void {
    this.mostrarMercados();
  }

  mostrarMercados(): void {
    this.mercadoService.findAll().subscribe((data) => {
      this.mercados = data;
      console.log(this.mercados);
    });
  }
}
