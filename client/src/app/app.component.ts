import { NgFor } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { User } from './class/user';
import { UserService } from './service/user.service';


@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private userService: UserService, pri

  ngOnInit(): void {
  }

  // [x: string]: any;
  //   title = 'client';

    public registerUser(addForm: NgForm): void {
      // document.getElementById('add-employee-form').click();
      this.userService.registerUser(addForm.value).subscribe(
        (response: User) => {
          console.log(response);
          console.log("jest ok");
          addForm.reset();
        },
        (error: HttpErrorResponse) => {
          console.error("nie jest ok");
          alert(error.message);
          addForm.reset();
        }
      );
    }  

    public login(loginForm: NgForm):void {
      this.userService.loginUser(loginForm.value).subscribe(
        (response: User) => {
          console.log(response);
          console.log("jest ok");
          loginForm.reset();
        },
        (error: HttpErrorResponse) => {
          console.error("nie jest ok");
          alert(error.message);
          loginForm.reset();
        }
      );
    }

    public onOpenModal(mode: string): void {
      const container = document.getElementById('main-container')!;
      const button = document.createElement('button');

      console.log("Is container null?" + container == null);
        
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      if (mode === 'add') {
        button.setAttribute('data-target', '#addEmployeeModal');
      }
      if (mode === 'login') {
        button.setAttribute('data-target', '#signIn');
      }
      container.appendChild(button);
      button.click();
    }
}
