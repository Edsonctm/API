import { Component } from '@angular/core';

@Component({
  selector: 'app-teste',
  templateUrl: './teste.component.html',
  styleUrls: ['./teste.component.scss']
})

export class TesteComponent  {
  lista = ['teste1', 'teste2']

  adicionar(x: string){
    this.lista.push(x)
    console.log(this.lista)
  }
}
