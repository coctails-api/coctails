import { NgModule } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { UserService } from '../userClass/user.service';

import { RegisterComponent } from './register.component';



@NgModule({
  declarations: [
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [RegisterComponent]
})
export class AppModule { }
