import { Component, Input, OnInit } from '@angular/core';
import { CestaItemComponent } from "../cesta-item/cesta-item.component";
import { CommonModule } from '@angular/common';
import { Pedido } from '../../../../models/pedido';

@Component({
  selector: 'app-cesta-list',
  standalone: true,
  imports: [CestaItemComponent, CommonModule],
  templateUrl: './cesta-list.component.html',
  styleUrl: './cesta-list.component.scss'
})
export class CestaListComponent implements OnInit {

  @Input() cesta: Pedido | null = null;


  trackByFn(index: number, item: any) {
    return item.id;
  }
  ngOnInit(): void {
    console.log(this.cesta?.lineaPedido);

  }

}

