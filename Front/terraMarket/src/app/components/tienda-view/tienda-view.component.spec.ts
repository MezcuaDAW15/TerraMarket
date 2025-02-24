import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiendaViewComponent } from './tienda-view.component';

describe('TiendaViewComponent', () => {
  let component: TiendaViewComponent;
  let fixture: ComponentFixture<TiendaViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TiendaViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TiendaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
