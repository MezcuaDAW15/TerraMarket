import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardTiendaComponent } from './card-tienda.component';

describe('CardTiendaComponent', () => {
  let component: CardTiendaComponent;
  let fixture: ComponentFixture<CardTiendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardTiendaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardTiendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
