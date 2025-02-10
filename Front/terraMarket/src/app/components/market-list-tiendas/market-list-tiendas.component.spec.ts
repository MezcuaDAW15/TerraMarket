import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarketListTiendasComponent } from './market-list-tiendas.component';

describe('MarketListTiendasComponent', () => {
  let component: MarketListTiendasComponent;
  let fixture: ComponentFixture<MarketListTiendasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MarketListTiendasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MarketListTiendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
