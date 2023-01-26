import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Discount} from "../classes/discount";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DiscountService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public addDiscount(discount: Discount): Observable<Discount>{
    return this.http.post<any>(`${this.apiServerUrl}/admin/discounts`,discount);
  }

  public getDiscounts(): Observable<Discount[]>{
    return this.http.get<Discount[]>(`${this.apiServerUrl}/admin/discounts`);
  }

  public deleteDiscount(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/admin/discounts/${id}`);
  }
}
