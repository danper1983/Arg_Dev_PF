import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { LogoARGPComponent } from './component/header/logo-argp/logo-argp.component';
import { RsocialesComponent } from './component/header/rsociales/rsociales.component';
import { AcercadeComponent } from './component/acercade/acercade.component';
import { ExperienciaComponent } from './component/experiencia/experiencia.component';
import { EducacionComponent } from './component/educacion/educacion.component';
import { SkillsComponent } from './component/skills/skills.component';
import { ProyectosComponent } from './component/proyectos/proyectos.component';
import { FooterComponent } from './component/footer/footer.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { interceptorProvider } from './service/interceptor-service';
import { FormsModule } from '@angular/forms';
import { NewExperienciaComponent } from './component/experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './component/experiencia/edit-experiencia/edit-experiencia.component';
import { NeweducacionComponent } from './component/educacion/neweducacion/neweducacion.component';
import { EditeducacionComponent } from './component/educacion/editeducacion/editeducacion.component';
import { EditAcercaDeComponent } from './component/acercade/edit-acerca-de/edit-acerca-de.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoARGPComponent,
    RsocialesComponent,
    AcercadeComponent,
    ExperienciaComponent,
    EducacionComponent,
    SkillsComponent,
    ProyectosComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    NeweducacionComponent,
    EditeducacionComponent,
    EditAcercaDeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
        // Specify ng-circle-progress as an import
        NgCircleProgressModule.forRoot({
          // set defaults here
          radius: 100,
          outerStrokeWidth: 16,
          innerStrokeWidth: 8,
          outerStrokeColor: "#78C000",
          innerStrokeColor: "#C7E596",
          animationDuration: 300,
        })
    ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
