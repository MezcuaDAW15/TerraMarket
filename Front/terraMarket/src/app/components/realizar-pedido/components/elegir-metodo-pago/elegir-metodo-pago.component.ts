import { Component, OnInit } from '@angular/core';
import { MetodopagoService } from '../../../../services/metodo-pago/metodopago.service';
import { MetodoPago } from '../../../../models/metodoPago';

@Component({
  selector: 'app-elegir-metodo-pago',
  standalone: true,
  imports: [],
  templateUrl: './elegir-metodo-pago.component.html',
  styleUrl: './elegir-metodo-pago.component.scss'
})
export class ElegirMetodoPagoComponent implements OnInit{
  metodos: MetodoPago[]= [];

  constructor(private metodosService : MetodopagoService){}
  ngOnInit(): void {
    this.mostrarMetodos()
  }

  mostrarMetodos():void{
    this.metodosService.findAll().subscribe((data) =>{
      this.metodos = data;
      
      console.log(this.metodos)
    })
  }
}
