import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from "./login/login.component";
import { RegistroComponent } from "./registro/registro.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RegistroComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'terraMarket';
}
