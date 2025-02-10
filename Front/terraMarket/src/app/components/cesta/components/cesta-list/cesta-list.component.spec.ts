import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CestaListComponent } from './cesta-list.component';

describe('CestaListComponent', () => {
  let component: CestaListComponent;
  let fixture: ComponentFixture<CestaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CestaListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CestaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
