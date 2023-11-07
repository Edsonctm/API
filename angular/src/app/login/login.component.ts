import { Component } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  teste: string
  urlImagem = "https://boomba.club/sex/uploads/posts/2022-11/1667881829_boomba-club-p-alexis-texas-anus-erotika-vkontakte-3.jpg"

  constructor(private loginService: LoginService){

    this.teste = loginService.funcaoTeste()

  }

}
