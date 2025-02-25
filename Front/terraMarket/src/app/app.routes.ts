import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';
import { RealizarPedidoComponent } from './components/realizar-pedido/realizar-pedido.component';
import { CestaComponent } from './components/cesta/cesta.component';
import { MarketViewComponent } from './components/market-view/market-view.component';
import { MercadosComponent } from './components/mercados/mercados.component';
import { ValoracionesComponent } from './components/valoraciones/valoraciones.component';
import { RegistroComponent } from './components/registro/registro.component';
import { TiendaViewComponent } from './components/tienda-view/tienda-view.component';
import { RegisterComponent } from './components/register/register.component';
import { ProductViewComponent } from './components/product-view/product-view.component';
import { EditarPerfilComponent } from './components/editar-perfil/editar-perfil.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'pedidos', component: PedidosComponent },
  { path: 'pedidos/:id', component: DetallesPedidoComponent },
  { path: 'mercados', component: MercadosComponent },
  { path: 'mercado/:id', component: MarketViewComponent },
  { path: 'cesta', component: CestaComponent },
  { path: 'registro', component: RegisterComponent },
  { path: 'home', component: MercadosComponent },
  { path: 'perfil', component: EditarPerfilComponent },
  { path: 'cesta', component: CestaComponent },
  { path: 'realizar-pedido', component: RealizarPedidoComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'valoracion', component: ValoracionesComponent },
  { path: ':idMercado/tiendas/:idTienda', component: TiendaViewComponent },
  { path: ':nombreMercado/:nombreProducto', component: ProductViewComponent },
  { path: ':nombreMercado', component: MarketViewComponent },
];
