import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {IndexComponent} from "./aaapages/index/index.component";
import {ConfirmEmailComponent} from "./aaapages/confirm-email/confirm-email.component";
import {AdminGuard} from "./admin-guard.service";
import {NewPasswordComponent} from "./aaapages/new-password/new-password.component";
import {AdminIndexComponent} from "./aaapages/admin/aaaadminPages/admin-index/admin-index.component";

const routes: Routes = [
  { path: '', component: IndexComponent, pathMatch: 'full'},
  { path: 'user/confirm', component: ConfirmEmailComponent, data: { token: ':token' }},
  { path: 'user/generateNewPassword', component: NewPasswordComponent, data: { token: ':token' }},
  { path: 'admin', component: AdminIndexComponent, pathMatch: 'full'},
  // { path: 'admin', loadChildren: () => import('./aaapages/admin/admin.module').then(m => m.AdminModule), canActivate: [AdminGuard]},
  { path: '**', component: IndexComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
