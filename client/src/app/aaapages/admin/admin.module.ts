import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import {Routes} from "@angular/router";
import {PanelComponent} from "./panel/panel.component";

@NgModule({
  declarations: [
    PanelComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
