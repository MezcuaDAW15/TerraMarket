import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { DetallesPedidoComponent } from './components/detalles-pedido/detalles-pedido.component';
import { EditarPerfilClienteComponent } from './components/editar-perfil-cliente/editar-perfil-cliente.component';

export const routes: Routes = [
    {path: '', redirectTo: '/pedidos', pathMatch:'full'},
    {path: 'pedidos', component: PedidosComponent },
    {path: 'detalles-pedido', component: DetallesPedidoComponent },
    {path: 'editar-perfil-cliente', component: EditarPerfilClienteComponent },
];
