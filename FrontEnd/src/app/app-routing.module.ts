import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAcercaDeComponent } from './component/acercade/edit-acerca-de/edit-acerca-de.component';
import { EditeducacionComponent } from './component/educacion/editeducacion/editeducacion.component';
import { NeweducacionComponent } from './component/educacion/neweducacion/neweducacion.component';
import { EditExperienciaComponent } from './component/experiencia/edit-experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './component/experiencia/new-experiencia.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'nuevaexp', component:NewExperienciaComponent},
  {path:'editexp/:id', component:EditExperienciaComponent},
  {path:'nuevaedu', component:NeweducacionComponent},
  {path: 'editedu/id', component:EditeducacionComponent},
  {path: 'editacercade/id', component:EditAcercaDeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
