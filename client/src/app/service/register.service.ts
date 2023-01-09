import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../classes/user";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http:HttpClient) { }

  public registerUser(user: User): Observable<void>{
    return this.http.post<void>(`${this.apiServerUrl}/user/register`,user);
  }
}
