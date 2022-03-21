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
    const id = window.sessionStorage.getItem('auth-id');
    this.doctorService.getUserDetails(id).subscribe(
      (value:any) => {
        this.userDetails = value;
      }
    )
  }

}
