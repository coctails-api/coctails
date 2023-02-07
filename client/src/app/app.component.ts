import { Component } from '@angular/core';
import { RegisterModalComponent } from './popupModal/register-modal/register-modal.component';
import { MatDialog } from '@angular/material/dialog';
import { LoginModalComponent } from './popupModal/login-modal/login-modal.component';
import { AuthService } from './service/auth.service';
import { AuthenticationService } from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'client';

  constructor(public authService: AuthenticationService) {}
}
