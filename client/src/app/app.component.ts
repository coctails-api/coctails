import { Component } from '@angular/core';
import {RegisterModalComponent} from "./popupModal/register-modal/register-modal.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  constructor() {
  }

  onOpenModalRegister(): void{

  }
}
