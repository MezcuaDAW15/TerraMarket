import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';
import { EditarPerfilClienteComponent } from './components/editar-perfil-cliente/editar-perfil-cliente.component';
import { RealizarPedidoComponent } from './components/realizar-pedido/realizar-pedido.component';
import { CestaComponent } from './components/cesta/cesta.component';
import { MarketViewComponent } from './components/market-view/market-view.component';
import { MercadosComponent } from './components/mercados/mercados.component';
import { ValoracionesComponent } from './components/valoraciones/valoraciones.component';
import { RegistroComponent } from './components/registro/registro.component';
import { TiendaViewComponent } from './components/tienda-view/tienda-view.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'pedidos', component: PedidosComponent },
  { path: 'pedidos/:id', component: DetallesPedidoComponent },
  { path: 'mercados', component: MercadosComponent },
  { path: 'mercado/:id', component: MarketViewComponent },
  { path: 'cesta', component: CestaComponent },
  { path: 'home', component: MercadosComponent },
  { path: 'realizar-pedido', component: RealizarPedidoComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'valoracion', component: ValoracionesComponent },
  { path: 'mercado/:id/tienda/:idTienda', component: TiendaViewComponent },
];
