import { Component, Input } from '@angular/core';
import { CestaItemComponent } from "../cesta-item/cesta-item.component";
import { CommonModule } from '@angular/common';
import { LineaPedido } from '../../../../models/lineaPedido';

@Component({
  selector: 'app-cesta-list',
  standalone: true,
  imports: [CestaItemComponent, CommonModule],
  templateUrl: './cesta-list.component.html',
  styleUrl: './cesta-list.component.scss'
})
export class CestaListComponent{
  @Input() cesta: LineaPedido[] = [];


  trackByFn(index: number, item: any) {
    return item.id;
  }

}

