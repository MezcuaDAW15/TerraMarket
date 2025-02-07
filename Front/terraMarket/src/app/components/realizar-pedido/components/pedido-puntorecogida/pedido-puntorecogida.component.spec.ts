import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidoPuntorecogidaComponent } from './pedido-puntorecogida.component';

describe('PedidoPuntorecogidaComponent', () => {
  let component: PedidoPuntorecogidaComponent;
  let fixture: ComponentFixture<PedidoPuntorecogidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PedidoPuntorecogidaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PedidoPuntorecogidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
