import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-segundo',
  templateUrl: './segundo.component.html',
  styleUrls: ['./segundo.component.css']
})
export class SegundoComponent {

@Output() mudouValor = new EventEmitter();

  @ViewChild('varInput') campoValorInput: ElementRef | undefined

  faca(){
    console.log(this.campoValorInput?.nativeElement.baseURI)
  }

}
