import { Component } from '@angular/core';
import { CardMarketComponent } from "../card-market/card-market.component";
import { CardTiendaComponent } from './components/card-tienda/card-tienda.component';

@Component({
  selector: 'app-market-list-tiendas',
  standalone: true,
  imports: [CardMarketComponent, CardTiendaComponent],
  templateUrl: './market-list-tiendas.component.html',
  styleUrl: './market-list-tiendas.component.scss'
})
export class MarketListTiendasComponent {

}
