import { Routes } from '@angular/router';
import path from 'node:path';
import { PedidosComponent } from './components/pedidos/pedidos.component';

export const routes: Routes = [
    {path: 'pedidos', component: PedidosComponent },
];
