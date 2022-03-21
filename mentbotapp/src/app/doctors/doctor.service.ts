import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const GET_USER_DETAILS = "http://localhost:8080/common/getUserDetails"
const GET_APPOINTMENT_DETAILS = "http://localhost:8080/doctors/getAppointments"
const CONFIRM_APPOINTMENT_DETAILS = "http://localhost:8080/doctors/confirmAppointment"
// const ADD_SPECIALITY = "http://localhost:8080/doctors/addSpecialities"
const ADD_SCHEDULE = "http://localhost:8080/doctors/addSchedule"
const ADD_DETAILS = "http://localhost:8080/doctors/addDetails"

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient, public router: Router) { }

  getUserDetails(id):Observable<any>{
    return this.http.get(`${GET_USER_DETAILS}?id=${id}`);
  }

//   addSpeciality(speciality):Observable<any>{
//     return this.http.post(ADD_SPECIALITY, {speciality});
//   }

  addSchedule(doctorId,availableDays,startTime,endTime):Observable<any>{
    return this.http.post(ADD_SCHEDULE, {doctorId,availableDays,startTime,endTime});
  }

  addDetails(id,practicing_date,prof_statement,specializationIds):Observable<any>{
    return this.http.post(`${ADD_DETAILS}?userId=${id}`, { practicing_date, prof_statement,specializationIds });
  }

  getAppointmentDetails(id):Observable<any>{
    return this.http.get(`${GET_APPOINTMENT_DETAILS}?doctorId=${id}`)
  }

  confirmAppointment(status,id):Observable<any>{
    return this.http.post(`${CONFIRM_APPOINTMENT_DETAILS}?appointmentId=${id}&status=${status}`,{id})
  }
}
