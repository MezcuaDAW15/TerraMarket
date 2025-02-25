import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card-market',
  standalone: true,
  imports: [],
  templateUrl: './card-market.component.html',
  styleUrl: './card-market.component.scss',
})
export class CardMarketComponent {
verTiendas(nombre: string) {
  window.location.href = `/${this.formatString(nombre)}`;
}
  @Input() nombre = '';
  @Input() cp = '';
  @Input() ciudad = '';

  formatString(input: string): string {
    return input
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .toLowerCase()
      .replace(/ /g, "-");
  }
}
