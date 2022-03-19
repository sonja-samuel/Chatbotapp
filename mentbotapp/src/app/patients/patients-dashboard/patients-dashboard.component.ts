import { Component, OnInit } from '@angular/core';
import { convertTypeAcquisitionFromJson } from 'typescript';
import { PatientsService } from '../patients.service';

@Component({
  selector: 'app-patients-dashboard',
  templateUrl: './patients-dashboard.component.html',
  styleUrls: ['./patients-dashboard.component.scss']
})
export class PatientsDashboardComponent implements OnInit {

  appointmentStatus : any;
  constructor(private patientService: PatientsService) { }

  ngOnInit(): void {
    this.getAppointmentStatus();
  }

  getAppointmentStatus():void{
    this.patientService.getAppointmentStatus().subscribe(
      (value:any) => {
        this.appointmentStatus = value;
      }
    )
  }

}
