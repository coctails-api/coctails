import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RegisterModalComponent } from '../../popupModal/register-modal/register-modal.component';
import { LoginModalComponent } from '../../popupModal/login-modal/login-modal.component';

@Component({
  selector: 'app-nav-unlogged',
  templateUrl: './nav-unlogged.component.html',
  styleUrls: ['./nav-unlogged.component.css'],
})
export class NavUnloggedComponent implements OnInit {
  isOpen = false;

  constructor(public dialog: MatDialog) {}

  ngOnInit(): void {}

  onOpenModalRegister(): void {
    this.dialog.open(RegisterModalComponent);
  }

  onOpenModalLogin(): void {
    this.dialog.open(LoginModalComponent);
  }

  toggleMenu() {
    this.isOpen = !this.isOpen;
  }
}
