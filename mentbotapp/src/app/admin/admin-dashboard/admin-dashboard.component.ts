import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';


@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent implements OnInit {
  appointmentDetails

  constructor(private adminService:AdminService){}
  ngOnInit(): void {
    this.getAppointmentDetails();
  }

  getAppointmentDetails():void{
    this.adminService.getAppointmentDetails().subscribe(
      (value:any) => {
        this.appointmentDetails = value;
      }
    );
  }

  updateUserDetails(id):void{
    this.adminService.updateUserDetails(id)
  }
  
}
