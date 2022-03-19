import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const GET_USER_DETAILS = "http://localhost:8080/common/getUserDetails"
const GET_APPOINTMENT_DETAILS = "http://localhost:8080/doctors/getMyAppointments"
const CONFIRM_APPOINTMENT_DETAILS = "http://localhost:8080/doctors/confirmAppointment"
const REJECT_APPOINTMENT_DETAILS = "http://localhost:8080/doctors/rejectAppointment"
const ADD_SPECIALITY = "http://localhost:8080/doctors/addSpecialities"
const ADD_SCHEDULE = "http://localhost:8080/doctors/addSchedule"
const ADD_DETAILS = "http://localhost:8080/doctors/addDetails"

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient, public router: Router) { }

  getUserDetails():Observable<any>{
    return this.http.get(GET_USER_DETAILS);
  }

  addSpeciality(speciality):Observable<any>{
    return this.http.post(ADD_SPECIALITY, {speciality});
  }

  addSchedule(practingDate,startTime,endTime):Observable<any>{
    return this.http.post(ADD_SCHEDULE, {practingDate,startTime,endTime});
  }

  addDetails(practingDate,professionalStatement):Observable<any>{
    return this.http.post(ADD_DETAILS, { practingDate , professionalStatement });
  }

  getAppointmentDetails():Observable<any>{
    return this.http.get(GET_APPOINTMENT_DETAILS)
  }

  confirmAppointment(id):Observable<any>{
    return this.http.post(CONFIRM_APPOINTMENT_DETAILS, {id})
  }

  rejectAppointment(id):Observable<any>{
    return this.http.post(REJECT_APPOINTMENT_DETAILS, {id})
  }
}
