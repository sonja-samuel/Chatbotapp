import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsermanageComponent } from './usermanage/usermanage.component';


@NgModule({
  declarations: [
    AdminDashboardComponent,
    // UsermanageComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
