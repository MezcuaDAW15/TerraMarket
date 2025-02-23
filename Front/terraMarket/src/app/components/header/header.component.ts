import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { MenuItem } from 'primeng/api';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { MenuModule } from 'primeng/menu';
import { BadgeModule } from 'primeng/badge';
import { CommonModule } from '@angular/common';
import { SessionService } from '../../services/session/session.service';
import { Router } from '@angular/router';
import { SelectedMarketService } from '../../services/global-state/selected-market.service';
import { Mercado } from '../../models/mercado';
import { MarketService } from '../../services/markets/market.service';
import { constrainedMemory } from 'process';




@Component({
  selector: 'app-header',
  standalone: true,
  imports: [ButtonModule, CommonModule, SidebarComponent, MenuModule, BadgeModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {

  items: MenuItem[] | undefined;

  usuarioLogueado = false;

  usuario: any = null;

  market: Mercado | undefined

  constructor(
    private sessionService: SessionService,
    private router: Router,
    private selectedMarketService: SelectedMarketService,
  ) { }


  ngOnInit() {
    this.cargarUsuario();

    this.cargarItems();

    this.selectedMarketService.market.subscribe({
      next: (market) => {
        if (market) {
          this.market = market
        }
      }
    })

  }

  cargarUsuario() {
    this.sessionService.usuario$.subscribe((usuario) => {

      this.usuarioLogueado = !!usuario;
      this.usuario = usuario;
    });

    this.sessionService.obtenerUsuario();

  }

  iniciarSesion() {
    this.sessionService.iniciarSesion();
  }

  cargarItems() {
    this.items = [
      {
        label: this.usuario.nombre,
        items: [
          {
            separator: true
          },
          {
            label: 'Mis pedidos',
            icon: 'pi pi-receipt text-2xl',
            routerLink: '/pedidos'
          },

          {
            label: 'Editar perfil',
            icon: 'pi pi-user-edit text-2xl',
            routerLink: '/editar-perfil-cliente'


          },

          {
            label: 'Cerrar sesión',
            icon: 'pi pi-sign-out text-2xl',
            command: () => {
              console.log('Cerrar sesión');
              this.sessionService.cerrarSesion();
            }
          },
          {
            separator: true,

          },

          {
            label: 'Eliminar mi cuenta',
            icon: 'pi pi-upload text-2xl'
          }
        ]
      }
    ]
  }
}
