import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorsDashboardComponent } from './doctors-dashboard/doctors-dashboard.component';
import { AdddetailComponent } from './adddetail/adddetail.component';
import { AvailabilitycheckComponent } from './availabilitycheck/availabilitycheck.component';
import { DocprofileComponent } from './docprofile/docprofile.component';
import { AddspecialityComponent } from './addspeciality/addspeciality.component';
const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: '',
        component: DoctorsDashboardComponent,
        data: {
          title: "Dashboard",
        },
      },
    {
      path: 'adddetails',
      component:AdddetailComponent ,
      data: {
        title: "Add Details",
      },
    },
    {
        path: 'availability',
        component:AvailabilitycheckComponent ,
        data: {
          title: "Availability Check",
        },
      },
      {
        path: 'docprofile',
        component: DocprofileComponent ,
        data: {
          title: "My Profile",
        },
      },
      {
        path: 'docspeciality',
        component: AddspecialityComponent ,
        data: {
          title: "My Speciality",
        },
      },
    ]),
  ],
  exports: [RouterModule]
})
export class DoctorsRoutingModule { }
