import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Mercado } from '../../models/mercado';

@Injectable({
  providedIn: 'root'
})
export class SelectedMarketService {
  private marketSubject = new BehaviorSubject<Mercado | undefined>(undefined)
  public market = this.marketSubject.asObservable()

  constructor() { }

  setMarket(market: Mercado) {
    this.marketSubject.next(market)
  }

  clearMarket() {
    this.marketSubject.next(undefined)
  }
}
