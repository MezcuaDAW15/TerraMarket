import { Component, OnInit} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-market-selector',
  standalone: true,
  imports: [FormsModule, DropdownModule],
  templateUrl: './market-selector.component.html',
  styleUrl: './market-selector.component.scss'
})
export class MarketSelectorComponent implements OnInit {
  markets: any[] = [];
  selectedMarket: any;

  ngOnInit() {
    this.markets = [
      { name: 'Market 1', code: 'M1' },
      { name: 'Market 2', code: 'M2' },
      { name: 'Market 3', code: 'M3' },
      { name: 'Market 4', code: 'M4' }
    ];
  }

}
