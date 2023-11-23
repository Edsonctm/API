import { RouterModule, Routes } from "@angular/router";
import { AppComponent } from "./app.component";
import { TesteComponent } from "./teste/teste.component";
import { ModuleWithProviders } from "@angular/core";
import { AppModule } from "./app.module";

const ROTAS_MAROTAS: Routes = [
    { path: '', component: AppComponent },
    { path: 'teste', component: TesteComponent }
]

export const roteador: ModuleWithProviders<AppModule> = RouterModule.forRoot(ROTAS_MAROTAS);