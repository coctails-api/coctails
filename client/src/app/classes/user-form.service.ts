import { Injectable } from '@angular/core';
import {UserForm} from "./user-form";

@Injectable({
  providedIn: 'root'
})
export class UserFormService {
  constructor(private userForm: UserForm) {
  }

  validation(userFormService: UserFormService):void{

  }


}
