import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidoDatospersonalesComponent } from './pedido-datospersonales.component';

describe('PedidoDatospersonalesComponent', () => {
  let component: PedidoDatospersonalesComponent;
  let fixture: ComponentFixture<PedidoDatospersonalesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PedidoDatospersonalesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PedidoDatospersonalesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
