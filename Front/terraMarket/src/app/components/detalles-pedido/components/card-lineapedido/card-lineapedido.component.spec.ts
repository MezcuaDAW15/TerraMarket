import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardLineapedidoComponent } from './card-lineapedido.component';

describe('CardLineapedidoComponent', () => {
  let component: CardLineapedidoComponent;
  let fixture: ComponentFixture<CardLineapedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardLineapedidoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardLineapedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
