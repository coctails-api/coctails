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
  conf: string;
  constructor(private route: ActivatedRoute, private registerService: RegisterService) {
    this.token = '';
    this.conf = '';
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
          alert(params)
          this.token = params['token'];
          alert(this.token)
        }
      );
    this.registerService.confirmEmail(this.token).subscribe((response: string) => {
      this.token = response.toString();
    }, (error: HttpErrorResponse) =>{
    });

    // this.route.queryParams.subscribe(params => {
    //       this.token = params.toString();
    //     }
    //   );
    // // this.conf = this.register.confirmEmail(this.token);
    // this.conf = this.register.test();
  }
}
