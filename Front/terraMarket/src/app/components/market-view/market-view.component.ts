import { Component } from '@angular/core';
import { BackComponent } from "../back/back.component";
import { BannerComponent } from "../banner/banner.component";
import { ListComponent } from "../list/list.component";

@Component({
  selector: 'app-market-view',
  standalone: true,
  imports: [BackComponent, BannerComponent, ListComponent],
  templateUrl: './market-view.component.html',
  styleUrl: './market-view.component.scss'
})
export class MarketViewComponent {

}
