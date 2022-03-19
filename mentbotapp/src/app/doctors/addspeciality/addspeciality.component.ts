import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-addspeciality',
  templateUrl: './addspeciality.component.html',
  styleUrls: ['./addspeciality.component.scss']
})
export class AddspecialityComponent implements OnInit {

  speciality : any;

  constructor(private doctorService: DoctorService,) { }

  ngOnInit(): void {
  }

  addSpeciality():void {
    this.doctorService.addSpeciality(this.speciality)
  }

}
