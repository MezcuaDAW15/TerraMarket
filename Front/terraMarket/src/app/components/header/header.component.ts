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
import { ClienteService } from '../../services/clientes/cliente.service';
import { PedidoServiceService } from '../../services/pedido-service.service';
import { Cliente } from '../../models/cliente';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';






@Component({
  selector: 'app-header',
  standalone: true,
  imports: [ButtonModule, CommonModule, SidebarComponent, MenuModule, BadgeModule, ReactiveFormsModule, DialogModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {

  items: MenuItem[] | undefined;

  usuarioLogueado = false;

  usuario: any = null;

  market: Mercado | undefined
  clienteLogin: any | null = null;
  cliente: Cliente | null = null;
  formulario: FormGroup;


  constructor(
    private sessionService: SessionService,
    private router: Router,
    private selectedMarketService: SelectedMarketService,
    private clienteService: ClienteService,
    private fb: FormBuilder,
    private pedidoService: PedidoServiceService
  ) {
    this.formulario = this.fb.group({
      username: ["", [Validators.required]],
      contrasena: ["", [Validators.required]]
    })
  }



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

    this.usuario = this.sessionService.obtenerUsuario();
    console.log('usuario --> ' + this.usuario);
    if (this.usuario) {
      this.usuarioLogueado = true;
      this.pedidoService.setId(this.usuario.id!);

      this.clienteService.findById(this.usuario.id).subscribe(
        (data) => {
          this.cliente = data;
          console.log('cliente --> ' + this.cliente);
        }
      );
    }

  }

  iniciarSesion(): void {

    this.clienteLogin = {
      username: this.formulario.value.username,
      contrasena: this.formulario.value.password
    }

    console.log('cliente formulario --> ' + this.clienteLogin.username);
    console.log('cliente formulario --> ' + JSON.stringify(this.clienteLogin));  // Muestra el objeto como una cadena JSON


    this.clienteService.login(this.clienteLogin).subscribe({
      next: (response: Cliente) => {
        console.log('Login successful', response);
        this.cliente = response;
        this.sessionService.iniciarSesion(this.cliente);
        this.usuarioLogueado = true;
        this.formulario.value.username = '';
        this.formulario.value.contrasena = '';
        this.pedidoService.setId(this.cliente.id!);
        this.closeDialog();
        this.router.navigate(['/home']);
      },
      error: (error) => {
        console.error('Login failed', error);
      }
    });

    console.log(this.cliente);
  }

  cargarItems() {
    this.items = [
      {
        label:  `${this.usuario?.nombre} ${this.usuario?.apellidos}`,
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
            routerLink: '/perfil'


          },

          {
            label: 'Cerrar sesión',
            icon: 'pi pi-sign-out text-2xl',
            command: () => {
              console.log('Cerrar sesión');
              this.cerrarSesion();
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

  loginVisible = false;
  showDialog() {

    this.loginVisible = true;
  }

  closeDialog() {
    this.loginVisible = false;
  }
  cerrarSesion() {
    this.sessionService.cerrarSesion();
    this.usuarioLogueado = false;
    this.router.navigate(['/home']);
    this.usuario = null;
  }
  irInicio(){
    this.router.navigate(['/home']);
  }
}
