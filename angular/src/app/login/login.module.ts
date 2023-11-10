import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import { SegundoComponent } from '../segundo/segundo.component';
import { CicloComponent } from '../ciclo/ciclo.component';



@NgModule({
  declarations: [LoginComponent, SegundoComponent, CicloComponent],
  imports: [
    CommonModule
  ],
  exports: [LoginComponent, SegundoComponent]
})
export class LoginModule { }
