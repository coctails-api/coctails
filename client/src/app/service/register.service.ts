import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../classes/user";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http:HttpClient) { }

  public registerUser(user: User): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization' : `Bearer ${localStorage.getItem('token')}`
      }),
      responseType: 'text' as 'json'
    };
    return this.http.post<any>(`${this.apiServerUrl}/user/register`,user);
  }

  public confirmEmail(email:string): Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/user/confirm?token=${email}`);
  }

  public generateNewToken(token: string): Observable<any>{
    return this.http.put<any>(`${this.apiServerUrl}/user/generateNewToken`, token);
  }
}
