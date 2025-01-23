import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { RippleModule } from 'primeng/ripple';
import { AvatarModule } from 'primeng/avatar';
import { StyleClassModule } from 'primeng/styleclass';
import { Sidebar } from 'primeng/sidebar';
import { DividerModule } from 'primeng/divider';


@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule, SidebarModule, ButtonModule, RippleModule, AvatarModule, StyleClassModule, DividerModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})
export class SidebarComponent {
  @ViewChild('sidebarRef') sidebarRef!: Sidebar;

  closeCallback(e: Event): void {
    this.sidebarRef.close(e);
  }

  sidebarVisible: boolean = false;

  categories = [
    {
      label: 'Categoría',

      subcategories: [
        { label: 'Aves y derivados', icon: 'Aves Derivados.svg' },
        { label: 'Carnicería', icon: 'Carniceria.svg' },
        { label: 'Charcutería y quesos', icon: 'Charcuteria.svg' },
        { label: 'Mariscos y pescados', icon: 'Mariscos y pescados.svg' }
      ]
    }
  ];
}
