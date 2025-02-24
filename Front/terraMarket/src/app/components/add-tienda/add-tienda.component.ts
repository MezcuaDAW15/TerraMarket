import { Component, OnInit } from '@angular/core';
import { BackComponent } from '../back/back.component';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { DropdownModule } from 'primeng/dropdown';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Mercado } from '../../models/mercado';
import { MercadoServiceService } from '../../services/mercado-service.service';

@Component({
  selector: 'app-add-tienda',
  standalone: true,
  imports: [BackComponent, CommonModule, ReactiveFormsModule, DropdownModule],
  templateUrl: './add-tienda.component.html',
  styleUrl: './add-tienda.component.scss',
})
export class AddTiendaComponent implements OnInit {
  addTiendaForm!: FormGroup;
  mercados: Mercado[] = [];
  imagenPreview!: SafeUrl | string;
  bannerPreview!: SafeUrl | string;

  constructor(
    private sanitizer: DomSanitizer,
    private fb: FormBuilder,
    private mercadoService: MercadoServiceService
  ) {
    this.addTiendaForm = this.fb.group({
      nombre: [null],
      foto: [null],
      selectedMercado: [],
    });
  }

  ngOnInit(): void {
    this.mercadoService.findAll().subscribe((data) => {
      this.mercados = data;
    });
  }

  previsualizarImagen(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.addTiendaForm.patchValue({ foto: file });
      const objectUrl = URL.createObjectURL(file);
      this.imagenPreview = this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    }
  }

  previsualizarBanner(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.addTiendaForm.patchValue({ bannerFoto: file });
      const objectUrl = URL.createObjectURL(file);
      this.bannerPreview = this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    }
  }

  addTienda() {}
}
