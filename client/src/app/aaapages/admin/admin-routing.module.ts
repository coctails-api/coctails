import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PanelComponent} from "./panel/panel.component";

const routes: Routes = [
  { path: '', component: PanelComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
