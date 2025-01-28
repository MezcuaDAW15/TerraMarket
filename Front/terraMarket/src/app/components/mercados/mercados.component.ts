import { Component, OnInit } from '@angular/core';
import { Mercado } from '../../models/mercado';
import { MercadoServiceService } from '../../services/mercado-service.service';

@Component({
  selector: 'app-mercados',
  standalone: true,
  imports: [],
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
    });
  }
}
