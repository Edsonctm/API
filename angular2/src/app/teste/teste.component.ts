import { Component } from '@angular/core';

@Component({
  selector: 'app-teste',
  templateUrl: './teste.component.html',
  styleUrls: ['./teste.component.scss']
})

export class TesteComponent  {
  nome: string = "Edson"
  valor: number = 2.99
  frase: string = "essa frase é apenas um exemplo."
}
