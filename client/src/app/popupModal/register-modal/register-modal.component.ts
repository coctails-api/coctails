import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../../classes/user";
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {UserFormService} from "../../classes/user-form.service";
import {UserForm} from "../../classes/user-form";
import {RegisterService} from "../../service/register.service";
import {HttpErrorResponse} from "@angular/common/http";
import {LoginModalComponent} from "../login-modal/login-modal.component";

@Component({
  selector: 'app-register-modal',
  templateUrl: './register-modal.component.html',
  styleUrls: ['./register-modal.component.css']
})
export class RegisterModalComponent implements OnInit {
  formGroup: FormGroup;
  submitted = false;
  registered = false;
  conflict = "";

  constructor(public dialog: MatDialog, private registerService: RegisterService) {
    this.formGroup = new FormGroup({
      email: new FormControl('',[
        Validators.required,
        Validators.pattern(/^\S+$/),
        Validators.email]),
      password: new FormControl('',[
        Validators.required,
        Validators.minLength(5),
        Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).+$/),
        Validators.pattern(/^\S+$/)
      ]),
      terms: new FormControl('', [Validators.required])
    });
  }

  ngOnInit() {
  }

  changeSubmit():void{
    this.submitted = true;
  }

  registerUser(): void{
    this.changeSubmit();
      const email = this.formGroup.get('email')?.value;
      const password = this.formGroup.get('password')?.value;

      let user = new User(email, password);

      if(this.formGroup.invalid)
        return;

      this.registerService.registerUser(user).subscribe((response: void) => {
          console.log(response);
          this.formGroup.reset();
          this.registered = true;
        }, (error: HttpErrorResponse) =>{
          {{error.status == 409 ? this.conflict = "Email już istnieje" : this.conflict = ""}}
        });
  }

  closeModal(): void{
    this.dialog.closeAll();
  }

  openLoginModal():void{
    this.closeModal();
    this.dialog.open(LoginModalComponent);
  }
}
