import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../../classes/user';
import { HttpErrorResponse } from '@angular/common/http';
import { RegisterService } from '../../service/register.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-regenerate-password',
  templateUrl: './regenerate-password.component.html',
  styleUrls: ['./regenerate-password.component.css'],
})
export class RegeneratePasswordComponent implements OnInit {
  formGroup: FormGroup;
  submit = false;
  info = '';
  constructor(
    private registerService: RegisterService,
    private dialog: MatDialog
  ) {
    this.formGroup = new FormGroup({
      email: new FormControl('', [
        Validators.required,
        Validators.pattern(/^\S+$/),
        Validators.email,
      ]),
    });
  }

  ngOnInit(): void {}

  generateNewEmailPassword(): void {
    const email = this.formGroup.get('email')?.value;
    let user = new User(email, '');

    this.registerService.generateNewEmailPassword(user).subscribe(
      (data) => {
        this.submit = true;
        this.closeModal();
      },
      (error: HttpErrorResponse) => {
        this.info = 'cos poszlo nie tak';
      }
    );
  }

  closeModal(): void {}
}
