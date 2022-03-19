import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

const GET_USER_DETAILS = "http://localhost:8080/common/getUserDetails"
const ADD_SPECIALITY = "http://localhost:8080/doctors/addSpecialities"
const ADD_SCHEDULE = "http://localhost:8080/doctors/addSchedule"
const ADD_DETAILS = "http://localhost:8080/doctors/addDetails"

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient, public router: Router) { }

  getUserDetails():any{
    this.http.get(GET_USER_DETAILS);
  }

  addSpeciality():any{
    this.http.post(ADD_SPECIALITY , {});
  }

  addSchedule():any{
    this.http.post(ADD_SCHEDULE , {});
  }

  addDetails():any{
    this.http.post(ADD_DETAILS , {});
  }
}
