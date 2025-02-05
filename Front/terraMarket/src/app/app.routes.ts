import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';
import { EditarPerfilClienteComponent } from './components/editar-perfil-cliente/editar-perfil-cliente.component';
import { MercadosComponent } from './components/mercados/mercados.component';

export const routes: Routes = [
    {path: '', redirectTo: '/pedidos', pathMatch:'full'},
    {path: 'pedidos', component: PedidosComponent },
    {path: 'mercados', component: MercadosComponent },
    {path: 'detalles-pedido', component: DetallesPedidoComponent },
    {path: 'editar-perfil-cliente', component: EditarPerfilClienteComponent },
    {path: 'pedido-datos-personales', redirectTo: '/pedido-datos-personales'},
];
