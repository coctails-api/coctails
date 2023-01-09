import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // constructor(private jwtHelper: JwtHelperService) {}
  //
  // public generateJwt(payload: any): string {
  //   // Wygeneruj token JWT z użyciem biblioteki angular2-jwt
  //   const jwt = this.jwtHelper.encode(payload);
  //
  //   // Umieść token w ciasteczku przeglądarki
  //   document.cookie = `jwt=${jwt}`;
  //
  //   return jwt;
  // }
}
