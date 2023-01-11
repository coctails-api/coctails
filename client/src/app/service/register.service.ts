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
      })
    };
    return this.http.post<any>(`${this.apiServerUrl}/user/register`,user);
  }
}
