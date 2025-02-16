import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElegirPuntoRecogidaComponent } from './elegir-punto-recogida.component';

describe('ElegirPuntoRecogidaComponent', () => {
  let component: ElegirPuntoRecogidaComponent;
  let fixture: ComponentFixture<ElegirPuntoRecogidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElegirPuntoRecogidaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ElegirPuntoRecogidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
