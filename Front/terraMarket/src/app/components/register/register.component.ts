import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { SafeHtmlPipe } from '../../pipes/safe-html.pipe';
import { Cliente } from '../../models/cliente';
import { RegisterService } from '../../services/register.service';
import { Router } from '@angular/router';
import { SessionService } from '../../services/session/session.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, SafeHtmlPipe],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent {
  registerFase1: FormGroup;
  registerFase2: FormGroup;
  fase1: boolean = true;
  showPasswd: boolean = false;
  showRepeat: boolean = false;

  constructor(
    private registerService: RegisterService,
    private router: Router,
    private sessionService: SessionService
  ) {
    this.registerFase1 = new FormGroup({
      name: new FormControl<string | null>(null, [Validators.required]),
      surnames: new FormControl<string | null>(null, [Validators.required]),
      email: new FormControl<string | null>(null, [
        Validators.required,
        Validators.pattern(
          /^[A-Za-z0-9.]{3,}@[A-Za-z0-9]{3,}\.[A-Za-z0-9]{2,}$/
        ),
      ]),
      username: new FormControl<string | null>(null, [Validators.required]),
    });

    this.registerFase2 = new FormGroup({
      birth: new FormControl<Date | null>(null, [Validators.required]),
      cp: new FormControl<number | null>(null, [
        Validators.required,
        Validators.min(10000),
      ]),
      dni: new FormControl<string | null>(null, [Validators.required]),
      password: new FormControl<string | null>(null, [
        Validators.required,
        Validators.pattern(/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$/),
      ]),
      repeat: new FormControl<string | null>(null, [Validators.required]),
      terms: new FormControl<boolean | null>(null),
    });
  }

  hasErrors(controlName: string): boolean {
    let control = this.registerFase1.get(controlName);
    if (!control) {
      control = this.registerFase2.get(controlName);
    }
    return control
      ? control.invalid && (control.dirty || control.touched)
      : false;
  }

  getError(controlName: string): ValidationErrors | null | undefined {
    let control = this.registerFase1.get(controlName);
    if (!control) {
      control = this.registerFase2.get(controlName);
    }
    return control?.errors;
  }

  chPasswd(e: Event) {
    e.preventDefault();
    this.showPasswd = !this.showPasswd;
  }

  chRepeat(e: Event) {
    e.preventDefault();
    this.showRepeat = !this.showRepeat;
  }

  chFase(e?: Event) {
    e?.preventDefault();
    this.fase1 = !this.fase1;
  }

  dniOnInput(e: Event) {
    const input = e.target as HTMLInputElement;
    input.value = input.value.toUpperCase();
  }

  changeFase(e: Event) {
    e.preventDefault();

    this.registerFase1.markAllAsTouched();

    if (this.registerFase1.invalid) {
      return;
    }

    this.chFase();
  }

  submit(e: Event) {
    e.preventDefault();

    this.registerFase1.markAllAsTouched();
    this.registerFase2.markAllAsTouched();

    if (this.registerFase1.invalid) {
      this.fase1 = true;
      return;
    }

    if (this.registerFase2.invalid) {
      return;
    }

    const form1Value = this.registerFase1.value;
    const form2Value = this.registerFase2.value;
    const cliente: Cliente = {
      nombre: form1Value.name,
      apellidos: form1Value.surnames,
      email: form1Value.email,
      username: form1Value.username,
      fechaNacimiento: form2Value.birth,
      contrasena: form2Value.password,
      cp: form2Value.cp,
    };

    this.registerService.register(cliente).subscribe({
      next: (response) => {
        localStorage.setItem('usuario', JSON.stringify(response));
        this.sessionService.setUsuario(response);
        this.router.navigate(['/']);
      },
      error: (error) => {
        console.error(error);
      },
    });
  }
}
