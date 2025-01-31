import { Mercado } from './../../models/mercado';
import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-banner',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './banner.component.html',
  styleUrl: './banner.component.scss'
})
export class BannerComponent {
  @Input() mercado: Mercado | null = null;

  getFormattedAddress(): string {
    if (!this.mercado?.direccion) return '';

    const { calle, numero, piso, puerta, cp, ciudad, provincia } = this.mercado.direccion;

    let address = `${calle} ${numero}`;
    if (piso) address += `, Piso ${piso}`;
    if (puerta) address += `, Puerta ${puerta}`;
    address += `, ${cp} ${ciudad}, ${provincia}`;

    return address;
  }

  getFormattedPhone(): string {
    if (!this.mercado?.telefono) return '';

    // Eliminar espacios y asegurarse de que solo hay números
    const cleanNumber = this.mercado.telefono.replace(/\D/g, '');

    // Si tiene 9 dígitos (formato español común), se agrupa en bloques de 3
    return cleanNumber.replace(/(\d{3})(\d{3})(\d{3})/, '$1 $2 $3');
  }
}
