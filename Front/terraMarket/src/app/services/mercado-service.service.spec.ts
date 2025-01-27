import { TestBed } from '@angular/core/testing';

import { MercadoServiceService } from './mercado-service.service';

describe('MercadoServiceService', () => {
  let service: MercadoServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MercadoServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
