import { Injectable } from '@angular/core';
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userRoles: string[] = [];

  constructor(public jwtHelper: JwtHelperService) {
    const token = localStorage.getItem('token');
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      this.userRoles = [decodedToken.roles];
    }
  }

  isAdmin(): boolean {
    return this.userRoles.some(r => r === "ADMIN");
  }

  isUser(): boolean{
    return this.userRoles.some(r => r === "USER");
  }
}
