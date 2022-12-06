import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../class/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}


  public registerUser(user: User): Observable<User>{
    var reqHeader = new HttpHeaders({
      'Access-Control-Allow-Origin' : '*',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + '11111'
    });
    console.log(user);
    return this.http.post<User>(`${this.apiServerUrl}/user/register`,JSON.stringify({user}), {headers:reqHeader});
  }

  public loginUser(user: User) {
    return this.http.post(`${this.apiServerUrl}/user/login`, JSON.stringify({user}));

  //public registerUser(user: User) {
    //return this.http.post<User>(`${this.apiServerUrl}/user/register`,JSON.stringify({user}));

  }
}