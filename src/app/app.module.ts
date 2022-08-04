import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { LogoARGPComponent } from './component/header/logo-argp/logo-argp.component';
import { RsocialesComponent } from './component/header/rsociales/rsociales.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoARGPComponent,
    RsocialesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
