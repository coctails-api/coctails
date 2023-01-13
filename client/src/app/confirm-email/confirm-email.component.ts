import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
import {RegisterService} from "../service/register.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-confirm-email',
  templateUrl: './confirm-email.component.html',
  styleUrls: ['./confirm-email.component.css']
})
export class ConfirmEmailComponent implements OnInit {
  token: string;
  info: string;
  constructor(private route: ActivatedRoute, private registerService: RegisterService) {
    this.token = '';
    this.info = '';
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
        console.error(error);
      }
    );
  }
}
