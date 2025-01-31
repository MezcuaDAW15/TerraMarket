import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card-market',
  standalone: true,
  imports: [],
  templateUrl: './card-market.component.html',
  styleUrl: './card-market.component.scss',
})
export class CardMarketComponent {
  @Input() nombre = '';
  @Input() cp = '';
}
