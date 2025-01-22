import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { MenuItem } from 'primeng/api';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { MenuModule } from 'primeng/menu';



@Component({
  selector: 'app-header',
  standalone: true,
  imports: [ButtonModule, SidebarComponent, MenuModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {

  items: MenuItem[] | undefined;

  ngOnInit() {
    this.items = [
      {
        label: 'usuario123',
        items: [
          {
            separator: true
          },
          {
            label: 'Mis pedidos',
            icon: 'pi pi-receipt'
          },

          {
            label: 'Editar perfil',
            icon: 'pi pi-user-edit',
            class: 'large-icon'



          },

          {
            label: 'Cerrar sesión',
            icon: 'pi pi-sign-out'
          },
          {
            separator: true,
            class: 'p-menu-separator-p'

          },

          {
            label: 'Eliminar mi cuenta',
            icon: 'pi pi-upload'
          }
        ]
      }
    ]
  }
}
