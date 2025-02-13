import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarPerfilClienteComponent } from './editar-perfil-cliente.component';

describe('EditarPerfilClienteComponent', () => {
  let component: EditarPerfilClienteComponent;
  let fixture: ComponentFixture<EditarPerfilClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarPerfilClienteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditarPerfilClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
