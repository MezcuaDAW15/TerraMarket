import { Component, OnInit } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { RatingModule } from 'primeng/rating';
import { FormBuilder, FormGroup, FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { ValoracionesService } from '../../services/valoraciones/valoraciones.service';
import { Tienda } from '../../models/tienda';
import { Cliente } from '../../models/cliente';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-valoraciones',
  standalone: true,
  imports: [
    BackComponent,
    RatingModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
  ],
  templateUrl: './valoraciones.component.html',
  styleUrl: './valoraciones.component.scss',
})
export class ValoracionesComponent implements OnInit {
  imagenUrl: string | null = null;
  valoracionForm!: FormGroup;
  tienda!: Tienda;
  cliente!: Cliente;

  constructor(
    private fb: FormBuilder,
    private valoracionesService: ValoracionesService
  ) {}

  ngOnInit(): void {
    this.valoracionForm = this.fb.group({
      valoracion: [null],
      comentario: [''],
    });

    /*     if (this.tienda?.imagen) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.tienda.imagen;
    } */

    this.valoracionesService.datosValoracion$.subscribe((datos) => {
      if (datos) {
        this.tienda = datos.tienda;
        this.cliente = datos.cliente;
      }
    });
  }

  onSubmit(): void {
    if (this.valoracionForm.valid) {
      const tiendaDTO = { id: this.tienda.id };
      const clienteDTO = { id: this.cliente.id };

      const valoracionData = {
        tienda: tiendaDTO,
        cliente: clienteDTO,
        puntuacion: this.valoracionForm.value.valoracion,
        resena: this.valoracionForm.value.comentario,
        fecha: new Date().toISOString(),
      };

      console.log('Datos enviados:', valoracionData);

      this.valoracionesService.registrarValoracion(valoracionData).subscribe(
        (response) => {
          console.log('Valoración enviada con éxito', response);
          window.history.back();
        },
        (error) => {
          console.error('Error al enviar valoración', error);
        }
      );
    }
  }
}
