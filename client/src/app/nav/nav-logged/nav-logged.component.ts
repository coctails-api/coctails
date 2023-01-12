import { Component, OnInit } from '@angular/core';
import {JwtHelperService} from "@auth0/angular-jwt";

@Component({
  selector: 'app-nav-logged',
  templateUrl: './nav-logged.component.html',
  styleUrls: ['./nav-logged.component.css']
})
export class NavLoggedComponent implements OnInit {
  userRoles: string[] = [];

  constructor(public jwtHelper: JwtHelperService) {
    const token = localStorage.getItem('token');
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      alert("Decode token: " + decodedToken)
      this.userRoles = [decodedToken.roles];
      alert("userRoles: " + this.userRoles)
    }
  }

  ngOnInit(): void {
  }

  logout():void{
    localStorage.removeItem('token');
  }

  userHasRole(role: string): boolean {
    return this.userRoles.some(r => r === role);
  }
}
