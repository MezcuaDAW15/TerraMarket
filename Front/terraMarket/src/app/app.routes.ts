import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';
import { MarketViewComponent } from './components/market-view/market-view.component';

export const routes: Routes = [

  {path: 'pedidos', component: PedidosComponent },
    {path: 'detalles-pedido', component: DetallesPedidoComponent },
    { path: 'mercado-central-valencia', redirectTo: '/mercado/1', pathMatch: 'full' },
    { path: 'mercado/:id', component: MarketViewComponent },
];
