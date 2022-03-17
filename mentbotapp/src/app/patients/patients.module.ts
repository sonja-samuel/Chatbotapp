import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientsRoutingModule } from './patients-routing.module';
import { PatientsDashboardComponent } from './patients-dashboard/patients-dashboard.component';
import { PatientprofileComponent } from './patientprofile/patientprofile.component';
import { ChatbotComponent } from './chatbot/chatbot.component';
import { AddappointmentComponent } from './addappointment/addappointment.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    PatientsDashboardComponent,
    PatientprofileComponent,
    // ChatbotComponent,
    AddappointmentComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    PatientsRoutingModule
  ]
})
export class PatientsModule { }
