import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdminIndexComponent} from "./aaaadminPages/admin-index/admin-index.component";
import {DiscountsComponent} from "./aaaadminPages/discounts/discounts.component";

const routes: Routes = [
  { path: '', component: AdminIndexComponent},
  { path: 'discounts', component: DiscountsComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
