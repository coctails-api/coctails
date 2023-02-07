import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminIndexComponent } from './aaaadminPages/admin-index/admin-index.component';
import { NavAdminComponent } from './nav/nav-admin/nav-admin.component';
import { DiscountsComponent } from './aaaadminPages/discounts/discounts.component';
import { DiscountPanelComponent } from './discount-panel/discount-panel.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AdminIndexComponent,
    NavAdminComponent,
    DiscountsComponent,
    DiscountPanelComponent,
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MatMenuModule,
    MatButtonModule,
    MatDialogModule,
    HttpClientModule,
  ],
})
export class AdminModule {}
