import { Component, Input, OnInit } from '@angular/core';
import { Tienda } from '../../../../models/tienda';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card-tienda',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-tienda.component.html',
  styleUrl: './card-tienda.component.scss'
})
export class CardTiendaComponent implements OnInit {

  @Input() tienda: Tienda | null = null;
  imagenUrl: string | null = null;
  ngOnInit(): void {
    if (this.tienda?.imagen) {
      this.imagenUrl = 'data:image/jpeg;base64,' + this.tienda.imagen;

    }
  }
}
