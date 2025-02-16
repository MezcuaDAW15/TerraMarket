import { Component } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/clientes/cliente.service';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  cliente: Cliente | null = null;
  formulario : FormGroup;

  constructor(private clienteService: ClienteService, private router : Router, private fb: FormBuilder){

    this.formulario = this.fb.group({
      username: ["", [Validators.required]],
      password: ["", [Validators.required]]
    })
  }

  iniciarSesion(): void{

    this.cliente = {
      username: this.formulario.value.username,
      contrasena: this.formulario.value.password
    }

    console.log('cliente formulario --> ' + this.cliente.username);
    console.log('cliente formulario --> ' + JSON.stringify(this.cliente));  // Muestra el objeto como una cadena JSON

    this.clienteService.login(this.cliente).subscribe((respuesta)=>{
      if (respuesta === 1) {

        const username = this.cliente?.username;
  
        if (username) {
          localStorage.setItem('cliente', username);  // Solo si username no es undefined
          this.router.navigate(['/home']);
        } else {
          console.error("El nombre de usuario es undefined");
        }
      }

    })
  }
}
