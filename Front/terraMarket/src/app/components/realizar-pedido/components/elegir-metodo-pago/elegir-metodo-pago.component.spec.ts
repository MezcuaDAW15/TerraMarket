import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElegirMetodoPagoComponent } from './elegir-metodo-pago.component';

describe('ElegirMetodoPagoComponent', () => {
  let component: ElegirMetodoPagoComponent;
  let fixture: ComponentFixture<ElegirMetodoPagoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElegirMetodoPagoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ElegirMetodoPagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
