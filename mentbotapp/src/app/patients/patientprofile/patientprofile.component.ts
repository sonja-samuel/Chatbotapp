import { Component, OnInit } from '@angular/core';
import { PatientsService } from '../patients.service';

@Component({
  selector: 'app-patientprofile',
  templateUrl: './patientprofile.component.html',
  styleUrls: ['./patientprofile.component.scss']
})
export class PatientprofileComponent implements OnInit {
  userDetails: any;

  constructor(private patientService: PatientsService) { }

  ngOnInit(): void {
    this.getUserDetails()
  }

  getUserDetails():void{
    const id = window.sessionStorage.getItem('auth-id');
    this.patientService.getUserDetails(id).subscribe(
      (value:any) => {
        this.userDetails = value;
      }
    )
  }

}
