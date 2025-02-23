import { Component, OnInit } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/clientes/cliente.service';
import { FormGroup, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-editar-perfil',
  standalone: true,
  imports: [BackComponent, ReactiveFormsModule],
  templateUrl: './editar-perfil.component.html',
  styleUrl: './editar-perfil.component.scss'
})
export class EditarPerfilComponent implements OnInit{
  clienteRecibido: Cliente | null = null; 
  clienteJson: string | null = null;
  clienteEncontrado: Cliente | null = null;
  formulario: FormGroup;
  usuarioId: number | null = null;

  constructor(private clienteService:ClienteService,
    private fb: FormBuilder
  ){
    
    this.formulario = this.fb.group({
      username: ['',[Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúñÑ0-9 ]{2,20}$/)],],
      nombre: ['',[Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúñÑ0-9 ]{2,20}$/)],],
      apellidos: ['', [Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúñÑ0-9 ]{2,30}$/)],],
      correo: ['', [Validators.required, Validators.email]],
      fechanacimiento: ['', [Validators.required]],
      contrasena: ['', [Validators.required]],
      cp: ['', [Validators.required]],
    })
  } 

  ngOnInit(): void {
    //let sessionStorageCliente = sessionStorage.getItem('cliente');
    //this.clienteRecibido = sessionStorageCliente ? JSON.parse(sessionStorageCliente) : null;

    // if (this.clienteRecibido) {
    //   this.clienteJson = JSON.stringify(this.clienteRecibido, null, 2);
    //   this.cargarDatosUsuario(this.clienteRecibido?.id!);
    //   console.log('perfil sesion storage --->' + this.clienteRecibido?.id);
    // }

    const usuario = this.clienteService.obtenerSesion()
    this.usuarioId = usuario ? usuario.id : null;
    if (this.usuarioId) {
      this.cargarDatosUsuario(this.usuarioId);
    } 
    
  }

  cargarDatosUsuario(idUsuario: number):void{
    this.clienteService.findById(idUsuario).subscribe(
      (data) =>{
        
        this.clienteEncontrado = data;
        console.log(this.clienteEncontrado)

        this.formulario.patchValue({
          username: this.clienteEncontrado.username,
          nombre: this.clienteEncontrado.nombre,
          apellidos: this.clienteEncontrado.apellidos,
          correo: this.clienteEncontrado.email,
          fechanacimiento: this.clienteEncontrado.fechaNacimiento,
          contrasena: '',
          cp: this.clienteEncontrado.cp,

        })
      }
    )
  }

  editarUsuario():void{
    // llamar al servicio para update
  }
}
