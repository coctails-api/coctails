import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {RegisterService} from "../../service/register.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-new-password',
  templateUrl: './new-password.component.html',
  styleUrls: ['./new-password.component.css']
})
export class NewPasswordComponent implements OnInit {
  token: string;
  formGroup: FormGroup;
  theSame = '';
  constructor(private route: ActivatedRoute, private registerService: RegisterService) {
    this.token = '';
    this.formGroup = new FormGroup({
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(5),
        Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).+$/),
        Validators.pattern(/^\S+$/)]),
      password2: new FormControl('', [
        Validators.required,
        Validators.minLength(5),
        Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).+$/),
        Validators.pattern(/^\S+$/)]),
    });
  }

  ngOnInit(): void {
    this.information();
  }

  information():void {
    this.route.queryParams.subscribe(params => {
        this.token = params['token'];
      }
    );
  }

  generateNewPassword(): void{
    const password = this.formGroup.get('password')?.value;
    const password2 = this.formGroup.get('password2')?.value;

    if(password!==password2){
      this.theSame = "Hasla nie sa takie same"
      return;
    }

    this.registerService.newPassowrd(password, this.token).subscribe(data => {
      alert("Możesz już się zalogować za pomocą nowego hasła")
    }, (error: HttpErrorResponse) => {
    });
  }
}
