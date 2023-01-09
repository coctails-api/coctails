import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {FormControl, FormGroup} from "@angular/forms";
import {User} from "../../classes/user";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-register-modal',
  templateUrl: './register-modal.component.html',
  styleUrls: ['./register-modal.component.css']
})
export class RegisterModalComponent implements OnInit {
  formGroup: FormGroup;

  constructor(public dialogRef: MatDialogRef<RegisterModalComponent>) {
    this.formGroup = new FormGroup({
      login: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
      phone: new FormControl(''),
    });
  }

  ngOnInit() {
  }

  registerUser(): void{
      const login = this.formGroup.get('login')?.value;
      const email = this.formGroup.get('email')?.value;
      const password = this.formGroup.get('password')?.value;
      const phone = this.formGroup.get('phone')?.value;

      let user = new User(login, email, password, phone);
      console.log(user);
  }
}
