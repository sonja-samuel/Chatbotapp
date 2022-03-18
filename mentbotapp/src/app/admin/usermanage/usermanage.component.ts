import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-usermanage',
  templateUrl: './usermanage.component.html',
  styleUrls: ['./usermanage.component.scss']
})
export class UsermanageComponent implements OnInit {
  userDetails: any;

  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
    this.getUserDetails();
  }

  getUserDetails():void{
    this.adminService.getUserDetails().subscribe(
      (value:any) => {
        this.userDetails = value;
      }
    );
  }
}
