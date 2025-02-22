import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { MenuItem } from 'primeng/api';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { MenuModule } from 'primeng/menu';
import { BadgeModule } from 'primeng/badge';
import { CommonModule } from '@angular/common';
import { SessionService } from '../../services/session/session.service';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { DialogModule } from 'primeng/dialog';
import { ClienteService } from '../../services/clientes/cliente.service';
import { Cliente } from '../../models/cliente';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PedidoServiceService } from '../../services/pedido-service.service';



@Component({
  selector: 'app-header',
  standalone: true,
  imports: [ButtonModule, CommonModule, SidebarComponent, MenuModule, BadgeModule, LoginComponent, DialogModule, ReactiveFormsModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {

  items: MenuItem[] | undefined;

  usuarioLogueado = false;

  usuario: any = null;

  cliente: Cliente | null = null;
  formulario : FormGroup;

  constructor(
    private sessionService: SessionService,
    private router: Router,
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
    //this.cargarUsuario();
    this.cargarItems();
  }

  // cargarUsuario() {
  //   this.sessionService.usuario$.subscribe((usuario) => {

  //     this.usuarioLogueado = usuario;
  //     this.usuario = usuario;
  //   });

  //   this.sessionService.obtenerUsuario();

  // }

  iniciarSesion() {
    //this.sessionService.iniciarSesion();

    this.cliente = {
      username: this.formulario.value.username,
      contrasena: this.formulario.value.contrasena
    }
    this.clienteService.login(this.cliente).subscribe(
      (response: Cliente) => {

        this.cliente = response; // obtenemos cliente del backend

        console.log('Login successful', response);
        
        this.usuarioLogueado = true;
        this.cargarItems();
        this.pedidoService.setId(this.cliente.id!);
        this.router.navigate(['/home']);
        this.closeDialog();
      },
      (error) => {
        console.error('Login failed', error);
      }
    );
    
    console.log(this.cliente);
  }

  cargarItems() {
    this.items = [
      {
        label: this.cliente?.username,
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

  loginVisible = false;
  showDialog() {

    this.loginVisible = true;
  }

  closeDialog(){
    this.loginVisible = false;
  }
}
