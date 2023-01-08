import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavUnloggedComponent } from './nav/nav-unlogged/nav-unlogged.component';
import { NavLoggedComponent } from './nav/nav-logged/nav-logged.component';
import { RegisterModalComponent } from './popupModal/register-modal/register-modal.component';
import { LoginModalComponent } from './popupModal/login-modal/login-modal.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavUnloggedComponent,
    NavLoggedComponent,
    RegisterModalComponent,
    LoginModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
