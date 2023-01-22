import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdminGuard} from "./admin-guard.service";
import {ConfirmEmailComponent} from "./confirm-email/confirm-email.component";
import {IndexComponent} from "./aaapages/index/index.component";
import {DashboardComponent} from "./aaapages/dashboard/dashboard.component";

const routes: Routes = [
  { path: '', component: IndexComponent, pathMatch: 'full'},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'user/confirm', component: ConfirmEmailComponent, data: { token: ':token' }},
  { path: '**', component: IndexComponent},
  // { path: 'admin', canActivate: [AdminGuard], loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
