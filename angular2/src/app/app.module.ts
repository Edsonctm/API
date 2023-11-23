import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TesteComponent } from './teste/teste.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatMenuModule} from '@angular/material/menu';
import { FundoAzulDirective } from './fundo-azul.directive';
import { NovaDiretivaDirective } from './nova-diretiva.directive';
import { TesteService } from './teste.service';
import { CamelCasePipe } from './camel-case.pipe';
import { roteador } from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    TesteComponent,
    FundoAzulDirective,
    NovaDiretivaDirective,
    CamelCasePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatMenuModule,
    roteador
  ],
  providers: [TesteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
