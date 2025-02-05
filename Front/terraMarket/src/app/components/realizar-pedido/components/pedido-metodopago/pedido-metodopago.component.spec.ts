import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidoMetodopagoComponent } from './pedido-metodopago.component';

describe('PedidoMetodopagoComponent', () => {
  let component: PedidoMetodopagoComponent;
  let fixture: ComponentFixture<PedidoMetodopagoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PedidoMetodopagoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PedidoMetodopagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
