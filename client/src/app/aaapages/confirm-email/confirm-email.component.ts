import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
import {RegisterService} from "../../service/register.service";

@Component({
  selector: 'app-confirm-email',
  templateUrl: './confirm-email.component.html',
  styleUrls: ['./confirm-email.component.css']
})
export class ConfirmEmailComponent implements OnInit {
  token: string;
  info: string;
  err;
  constructor(private route: ActivatedRoute, private registerService: RegisterService) {
    this.token = '';
    this.info = '';
    this.err = 1;
  }

  ngOnInit() {
    this.informationForUser();
  }

  informationForUser():void{
    this.route.queryParams.subscribe(params => {
        this.token = params['token'];
      }
    );

    this.registerService.confirmEmail(this.token).subscribe(
      data => {
        this.info = data;
      },
      error => {
        this.err = error.status;
        console.error(error.error);
      }
    );
  }

  generateNewToken(): void{
    console.log(this.token)
    this.registerService.generateNewToken(this.token).subscribe(
      response => {
        this.info = response;
      }
    )
  }
}
