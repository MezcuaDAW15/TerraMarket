import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChipTiendaComponent } from './chip-tienda.component';

describe('ChipTiendaComponent', () => {
  let component: ChipTiendaComponent;
  let fixture: ComponentFixture<ChipTiendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChipTiendaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChipTiendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
