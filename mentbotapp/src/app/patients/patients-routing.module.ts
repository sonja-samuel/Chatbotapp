import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientsDashboardComponent } from './patients-dashboard/patients-dashboard.component';
import { AddappointmentComponent } from './addappointment/addappointment.component';
import { ChatbotComponent } from './chatbot/chatbot.component';
import { PatientprofileComponent } from './patientprofile/patientprofile.component';
import { AddDetailsComponent } from './add-details/add-details.component';

const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: '',
        component: PatientsDashboardComponent,
        data: {
          title: "Dashboard",
        },
      },
      {
        path: 'patientprofile',
        component:PatientprofileComponent,
        data: {
          title: "My Profile",
        },
      },
      {
        path: 'adddetails',
        component: AddDetailsComponent,
        data: {
          title: "Add Details",
        },
      },
      {
        path: 'addappointment',
        component: AddappointmentComponent,
        data: {
          title: "Add Appointment",
        },
      },

      {
        path: 'chat',
        component: ChatbotComponent,
        data: {
          title: "Chat With Me",
        },
      },
    ]),
  ],
  exports: [RouterModule]
})
export class PatientsRoutingModule { }
