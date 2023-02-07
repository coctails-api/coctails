import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../classes/user';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { HttpHeaderService } from './http-header.service';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(
    private http: HttpClient,
    private httpHeader: HttpHeaderService
  ) {}

  public registerUser(user: User): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/user/register`, user);
  }

  public confirmEmail(email: string): Observable<any> {
    return this.http.get<any>(
      `${this.apiServerUrl}/user/confirm?token=${email}`
    );
  }

  public generateNewToken(token: string): Observable<any> {
    return this.http.put<any>(
      `${this.apiServerUrl}/user/generateNewToken`,
      JSON.stringify({ token: token }),
      { headers: this.httpHeader.getHeader() }
    );
  }

  public generateNewEmailPassword(user: User): Observable<any> {
    return this.http.post<any>(
      `${this.apiServerUrl}/user/generateNewEmailPassword`,
      user
    );
  }

  public newPassowrd(password: string, token: string): Observable<any> {
    alert(password + ' ' + token);
    return this.http.put<any>(`${this.apiServerUrl}/user/newPassword`, {
      password,
      token,
    });
  }
}
