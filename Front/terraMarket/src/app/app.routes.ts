import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';
import { MercadosComponent } from './components/mercados/mercados.component';

export const routes: Routes = [
  { path: '', redirectTo: '/mercados', pathMatch: 'full' },
  { path: 'pedidos', component: PedidosComponent },
  { path: 'detalles-pedido', component: DetallesPedidoComponent },
  { path: 'mercados', component: MercadosComponent },
];
