import { CardComponent } from './components/card/card.component';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from "./components/sidebar/sidebar.component";
import { PedidosComponent } from "./components/pedidos/pedidos.component";
import { BackComponent } from './components/back/back.component';
import { MarketViewComponent } from "./components/market-view/market-view.component";
import { FiltrosComponent } from "./components/filtros/filtros.component";
import { CestaItemComponent } from "./components/cesta/components/cesta-item/cesta-item.component";
import { CestaComponent } from "./components/cesta/cesta.component";
import { MarketListTiendasComponent } from "./components/market-list-tiendas/market-list-tiendas.component";
import { RealizarPedidoComponent } from "./components/realizar-pedido/realizar-pedido.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, CardComponent, PedidosComponent, BackComponent, MarketViewComponent, FiltrosComponent, CestaItemComponent, CestaComponent, MarketListTiendasComponent, RealizarPedidoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'terraMarket';
}
