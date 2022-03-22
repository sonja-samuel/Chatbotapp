import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsermanageComponent } from './usermanage/usermanage.component';


@NgModule({
  imports: [
    RouterModule.forChild([
    //   {
    //     path: '',
    //     component: AdminDashboardComponent,
    //     data: {
    //       title: "Dashboard",
    //     },
    //   },
      {
        path: 'usermanage',
        component: UsermanageComponent,
        data: {
          title: "User Manage",
        },
      },
    ]),
  ],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
