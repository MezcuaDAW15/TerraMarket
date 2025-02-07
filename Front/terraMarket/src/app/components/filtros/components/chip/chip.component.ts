import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-chip',
  standalone: true,
  imports: [],
  templateUrl: './chip.component.html',
  styleUrl: './chip.component.scss'
})
export class ChipComponent{
  @Input() categoriaP: any | null = null;
  @Output() categorySelected = new EventEmitter<number>();

  onCategoryChange(event: any) {
    if (event.target.checked) {
      this.categorySelected.emit(this.categoriaP.id);
    } else {
      this.categorySelected.emit(-this.categoriaP.id); // Para eliminar si se desmarca
    }
  }
}
