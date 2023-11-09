import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-segundo',
  templateUrl: './segundo.component.html',
  styleUrls: ['./segundo.component.css']
})
export class SegundoComponent {

@Output() mudouValor = new EventEmitter();

  valor: number = 0;

  incremento(){
    this.valor++
    this.mudouValor.emit({novoValor: this.valor})
  }

  decremento(){
    this.valor--
    this.mudouValor.emit({novoValor: this.valor})
  }

}
