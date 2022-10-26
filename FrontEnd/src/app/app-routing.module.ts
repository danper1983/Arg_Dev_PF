import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewExperienciaComponent } from './component/experiencia/new-experiencia.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'nuevaexp', component:NewExperienciaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
