import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`, employee);
  }
}
