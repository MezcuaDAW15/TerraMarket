import { CategoriaT } from './../../../../models/categoriaT';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoriaP } from '../../../../models/categoriaP';
import { ChipComponent } from "../chip/chip.component";


@Component({
  selector: 'app-chips',
  standalone: true,
  imports: [CommonModule, ChipComponent],
  templateUrl: './chips.component.html',
  styleUrl: './chips.component.scss'
})
export class ChipsComponent {
  @Input() categoriaT: CategoriaT | null = null;

  @Output() categorySelected = new EventEmitter<number>();

  onCategoryChange(categoryId: number) {
    this.categorySelected.emit(categoryId);
  }

  getListCategoriesP(): CategoriaP[] {
    if (!this.categoriaT?.listaCategoriaP) return [];
    return this.categoriaT.listaCategoriaP;
  }
  trackByFn(index: number, item: any) {
    return item.id;
  }


}
