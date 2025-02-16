import { Component } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/clientes/cliente.service';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  cliente : Cliente | null = null;

  constructor(private clienteService: ClienteService){}

  
}
