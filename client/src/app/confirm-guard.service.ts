import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';
import { AuthService } from './service/auth.service';
import { AuthenticationService } from './service/authentication.service';

@Injectable({
  providedIn: 'root',
})
export class ConfirmGuard implements CanActivate {
  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (!this.authService.isUserLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/index']);
      return false;
    }
  }
}
