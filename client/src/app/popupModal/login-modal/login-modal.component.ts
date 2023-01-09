import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {AuthenticationService} from "../../service/authentication.service";
import {User} from "../../classes/user";

@Component({
  selector: 'app-login-modal',
  templateUrl: './login-modal.component.html',
  styleUrls: ['./login-modal.component.css']
})
export class LoginModalComponent implements OnInit {
  formGroup: FormGroup;

  constructor(public dialog: MatDialog, private authenticateService: AuthenticationService) {
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

    let user = new User(email, password);

    this.authenticateService.authenticate(user).subscribe(data => {
      localStorage.setItem('token',data.token);
      if (localStorage.getItem('token') !== null) {

        // this.routerService.routeToDashboard();
      }else{
        alert("CHUJA NIE ZALOGUJESZ SIE BEDZIESZ SIE Z TYM JEBAC CALE ZYCIE");
      }
    });
  }

  closeModal():void{
    this.dialog.closeAll();
  }
}
