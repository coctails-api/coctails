import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {RegisterModalComponent} from "../popupModal/register-modal/register-modal.component";
import {LoginModalComponent} from "../popupModal/login-modal/login-modal.component";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(public authService: AuthenticationService) {
  }

  ngOnInit(): void {
  }
}
