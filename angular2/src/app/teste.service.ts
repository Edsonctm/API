import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TesteService {

  constructor() { }

  teste(): string{
    return "testado"
  }
}
