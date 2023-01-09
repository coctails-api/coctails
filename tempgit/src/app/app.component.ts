import { Component } from '@angular/core';
import {RegisterModalComponent} from "./popupModal/register-modal/register-modal.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  constructor(public dialog: MatDialog) {
  }

  onOpenModalRegister(): void{

  }
}
