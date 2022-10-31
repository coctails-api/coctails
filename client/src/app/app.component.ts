import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { User } from './class/user';
import { UserService } from './service/user.service';


@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  // [x: string]: any;
  //   title = 'client';

    public registerUser(addForm: NgForm): void {
      // document.getElementById('add-employee-form').click();
      this.userService.registerUser(addForm.value).subscribe(
        (response: User) => {
          console.log(response);
          addForm.reset();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      );
    }  

    public onOpenModal(mode: string): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      if (mode === 'add') {
        button.setAttribute('data-target', '#addEmployeeModal');
      }
      container.appendChild(button);
      button.click();
    }
}
