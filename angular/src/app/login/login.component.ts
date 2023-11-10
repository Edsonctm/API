import { Component } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  valor2: number = 10
  componentView: boolean = false

  mudaValor(){
    this.valor2++
  }

  fechaComponent(){
    this.componentView = !this.componentView
  }

}
