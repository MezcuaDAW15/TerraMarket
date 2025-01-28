import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';

export const routes: Routes = [
    {path: '', redirectTo: '/pedidos', pathMatch:'full'},
    {path: 'pedidos', component: PedidosComponent },
    {path: 'detalles-pedido', component: DetallesPedidoComponent },
];
