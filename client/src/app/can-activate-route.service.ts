import { Injectable } from '@angular/core';
import {AuthenticationService} from "./service/authentication.service";
import {RouterService} from "./service/router.service";
import {ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CanActivateRouteService {

  constructor(private authService: AuthenticationService, private routerService: RouterService) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if(!this.authService.isUserLoggedIn())
    {
      this.routerService.routeToIndex();
    }
    return this.authService.isUserLoggedIn();
  }
}
