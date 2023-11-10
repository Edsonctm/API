import { Component, Input, OnChanges, OnInit } from '@angular/core';

@Component({
  selector: 'app-ciclo',
  templateUrl: './ciclo.component.html',
  styleUrls: ['./ciclo.component.css']
})
export class CicloComponent implements OnInit, OnChanges {

  @Input() valor: number = 0

  constructor(){
    console.log('constructor')
  }

  ngOnInit() {
    console.log("init")
  }

  ngOnChanges(){
    console.log('changes')
  }

  ngOnDestroy(){
    console.log("destroi")
  }



}
