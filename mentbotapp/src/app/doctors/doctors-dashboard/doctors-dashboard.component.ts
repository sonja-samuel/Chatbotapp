import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctors-dashboard',
  templateUrl: './doctors-dashboard.component.html',
  styleUrls: ['./doctors-dashboard.component.scss']
})
export class DoctorsDashboardComponent implements OnInit {

  appointmentDetails : any;
  constructor(private doctorService: DoctorService) { }

  ngOnInit(): void {
    this.getAppointmentDetails();
  }

  getAppointmentDetails():void{
   
    this.doctorService.getAppointmentDetails().subscribe(
      (value:any) => {
        this.appointmentDetails = value;
      }
    )
  }

  acceptAppointment(id):void{
    const status = 'CONFIRMED'
    console.log(status);
    this.doctorService.confirmAppointment(status,id).subscribe();
  }

  cancelAppointment(id):void{
    const status = 'CANCELED'
    this.doctorService.confirmAppointment(status,id).subscribe();
  }

}
