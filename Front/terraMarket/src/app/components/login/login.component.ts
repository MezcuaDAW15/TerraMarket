import { Component } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/clientes/cliente.service';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { FormGroup, Validators } from '@angular/forms';
import { SessionService } from '../../services/session/session.service';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  clienteLogin: any | null = null;
  cliente: Cliente | null = null;
  formulario: FormGroup;

  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private fb: FormBuilder,
    private sessionService: SessionService
  ) {

    this.formulario = this.fb.group({
      username: ["", [Validators.required]],
      password: ["", [Validators.required]]
    })
  }

  iniciarSesion(): void {

    this.clienteLogin = {
      username: this.formulario.value.username,
      contrasena: this.formulario.value.password
    }

    console.log('cliente formulario --> ' + this.clienteLogin.username);
    console.log('cliente formulario --> ' + JSON.stringify(this.clienteLogin));  // Muestra el objeto como una cadena JSON

    // this.clienteService.login(this.clienteLogin).subscribe(
    //   (response: Cliente) => {
    //     console.log('Login successful', response);
    //   },
    //   (error) => {
    //     console.error('Login failed', error);
    //   }
    // );
    this.clienteService.login(this.clienteLogin).subscribe({
      next: (response: Cliente) => {
        console.log('Login successful', response);
        this.cliente = response;
        this.sessionService.iniciarSesion(this.cliente);
        this.router.navigate(['/home']);
      },
      error: (error) => {
        console.error('Login failed', error);
      }
    });

    console.log(this.cliente);
  }
}
