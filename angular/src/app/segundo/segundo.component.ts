import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-segundo',
  templateUrl: './segundo.component.html',
  styleUrls: ['./segundo.component.css'],
  inputs:['nomeApp:nome']
})
export class SegundoComponent implements OnInit {

  // @Input('nome') 
  nomeApp: string = ''

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
