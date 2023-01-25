import { Injectable } from '@angular/core';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HttpHeaderService {

  constructor() { }

  getHeader(): HttpHeaders{
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return headers;
  }
}
