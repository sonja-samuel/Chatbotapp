import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-docprofile',
  templateUrl: './docprofile.component.html',
  styleUrls: ['./docprofile.component.scss']
})
export class DocprofileComponent implements OnInit {

  userDetails : any;

  constructor(private doctorService: DoctorService) { }

  ngOnInit(): void {
    this.getUserDetails();
  }

  getUserDetails():void{
  
    this.doctorService.getUserDetails().subscribe(
      (value:any) => {
        this.userDetails = value;
      },
     
    )
  }

}
