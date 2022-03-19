import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const AVAILABLE_SLOTS = "http://localhost:8080/appointment/getAvailableSlot";
const ADD_APPOINTMENT = "http://localhost:8080/appointment/addAppointment";
const GET_USER_DETAILS = "http://localhost:8080/common/getUserDetails"
const ADD_DETAILS = "http://localhost:8080/patient/addDetails";
const GET_APPOINTMENT_STATUS = "http://localhost:8080/patient/getAppointmentStatus";

@Injectable({
  providedIn: 'root'
})
export class PatientsService {

  constructor(private http: HttpClient, public router: Router) { }

  getAvailableSlot():Observable<any>{
    return this.http.get(AVAILABLE_SLOTS);
  }

  getAppointmentStatus():Observable<any>{
    return this.http.get(GET_APPOINTMENT_STATUS);
  }

  addAppointment(dateOfAppointment,speciality,doctorName,slots):Observable<any>{
    return this.http.post(ADD_APPOINTMENT, { dateOfAppointment, speciality, doctorName, slots });
  }

  addPatientDetails(bloodgroup , gender):Observable<any>{
    return this.http.post(ADD_DETAILS, { bloodgroup, gender });
  }

  getUserDetails():Observable<any>{
    return this.http.get(GET_USER_DETAILS);
  }

}
