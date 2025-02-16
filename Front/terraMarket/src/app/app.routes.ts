import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';
import { EditarPerfilClienteComponent } from './components/editar-perfil-cliente/editar-perfil-cliente.component';
import { RealizarPedidoComponent } from './components/realizar-pedido/realizar-pedido.component';
import { CestaComponent } from './components/cesta/cesta.component';
import { MarketViewComponent } from './components/market-view/market-view.component';
import { MercadosComponent } from './components/mercados/mercados.component';
import { RegistroComponent } from './components/registro/registro.component';
import { LoginComponent } from './components/login/login.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'pedidos', component: PedidosComponent },
  { path: 'pedidos/:id', component: DetallesPedidoComponent },
  { path: 'mercado/:id', component: MarketViewComponent },
  { path: 'cesta', component: CestaComponent },
  { path: 'home', component: MercadosComponent },
  { path: 'realizar-pedido', component: RealizarPedidoComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'login', component: LoginComponent },
];
