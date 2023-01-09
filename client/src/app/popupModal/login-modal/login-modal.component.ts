import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-login-modal',
  templateUrl: './login-modal.component.html',
  styleUrls: ['./login-modal.component.css']
})
export class LoginModalComponent implements OnInit {
  formGroup: FormGroup;

  constructor(public dialog: MatDialog) {
    this.formGroup = new FormGroup({
      email: new FormControl('',[
        Validators.required,
        Validators.pattern(/^\S+$/),
        Validators.email]),
      password: new FormControl('',[
        Validators.required,
        Validators.minLength(5),
        Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).+$/),
        Validators.pattern(/^\S+$/)]),
    });
  }

  ngOnInit(): void {
  }

  login():void{
    const email = this.formGroup.get('email')?.value;
    const password = this.formGroup.get('password')?.value;
  }

  closeModal():void{
    this.dialog.closeAll();
  }
}
