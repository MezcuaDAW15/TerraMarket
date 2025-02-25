import { Component, OnInit } from '@angular/core';
import { Mercado } from '../../models/mercado';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { FormsModule } from '@angular/forms';
import { MercadoServiceService } from '../../services/mercado-service.service';
import { CardMarketComponent } from '../card-market/card-market.component';
import { RegistroComponent } from '../registro/registro.component';
import { RouterLink, Router } from '@angular/router';

@Component({
  selector: 'app-mercados',
  standalone: true,
  imports: [
    CardMarketComponent,
    AutoCompleteModule,
    FormsModule,
    RegistroComponent,
    RouterLink,
  ],
  templateUrl: './mercados.component.html',
  styleUrl: './mercados.component.scss',
})
export class MercadosComponent implements OnInit {
  mercados: Mercado[] = [];
  mercadosFiltrados: Mercado[] = [];
  searchText: Mercado | null = null;
  filteredItems: Mercado[] = [];

  constructor(private mercadoService: MercadoServiceService) {}
  ngOnInit(): void {
    this.mostrarMercados();
  }

  mostrarMercados(): void {
    this.mercadoService.findAll().subscribe((data) => {
      this.mercados = data;
      this.mercadosFiltrados = [...this.mercados];
    });
  }

  // Filtra los mercados en el autocompletado
  search(event: any) {
    const query = event.query.toLowerCase();
    this.filteredItems = this.mercados.filter((item) =>
      item.nombre.toLowerCase().includes(query)
    );
  }

  // Muestra solo el mercado seleccionado
  filtrarMercadoSeleccionado() {
    if (this.searchText) {
      this.mercadosFiltrados = [this.searchText];
    } else {
      this.mercadosFiltrados = [...this.mercados];
    }
  }
}
