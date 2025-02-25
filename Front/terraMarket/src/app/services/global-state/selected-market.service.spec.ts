import { TestBed } from '@angular/core/testing';

import { SelectedMarketService } from './selected-market.service';

describe('SelectedMarketService', () => {
  let service: SelectedMarketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SelectedMarketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
