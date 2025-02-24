import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { RippleModule } from 'primeng/ripple';
import { AvatarModule } from 'primeng/avatar';
import { StyleClassModule } from 'primeng/styleclass';
import { Sidebar } from 'primeng/sidebar';
import { DividerModule } from 'primeng/divider';
import { CategoriesService } from '../../services/categories/categories.service';
import { CategoriaT } from '../../models/categoriaT';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';


@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule, RouterModule, SidebarModule, ButtonModule, RippleModule, AvatarModule, StyleClassModule, DividerModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})
export class SidebarComponent implements OnInit {

  @ViewChild('sidebarRef') sidebarRef!: Sidebar;
  categorias: CategoriaT[] = [];

  constructor(
    private categoriesService: CategoriesService,
    private router: Router

  ) { }

  closeCallback(e: Event): void {
    this.sidebarRef.close(e);
  }

  sidebarVisible: boolean = false;
  ngOnInit(): void {
    this.categoriesService.findAll().subscribe((data) => {
      this.categorias = data;
    });
    console.log(this.categorias);



    this.router.events.subscribe(() => {
      this.sidebarVisible = false;
    });
  }
  navigateToCategory(categoryId: number) {
    window.location.href = `/mercado/3?categoria=${categoryId}`;
  }


}
