import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const AVAILABLE_SLOTS = "http://localhost:8080/appointment/getAvailableSlots";
const ADD_APPOINTMENT = "http://localhost:8080/appointment/addAppointment";
const GET_USER_DETAILS = "http://localhost:8080/common/getUserDetails"
const ADD_DETAILS = "http://localhost:8080/patient/addDetails";
const GET_APPOINTMENT_STATUS = "http://localhost:8080/patient/getAppointments";
const GET_DOCTOR_NAME = "http://localhost:8080/appointment/getDoctors";

@Injectable({
  providedIn: 'root'
})
export class PatientsService {

  constructor(private http: HttpClient, public router: Router) { }

  getAvailableSlot(doctorId , date):Observable<any>{
    return this.http.get(`${AVAILABLE_SLOTS}?doctorId=${doctorId}&date=${date}`);
  }

  getAppointmentStatus(id):Observable<any>{
    return this.http.get(`${GET_APPOINTMENT_STATUS}?patientId=${id}`);
  }

  addAppointment(dateOfAppointment, specId, docId, patient_id, slots):Observable<any>{
    return this.http.post(ADD_APPOINTMENT, { dateOfAppointment, specId, docId, patient_id, slots});
  }

  addPatientDetails(id,bloodgroup , gender):Observable<any>{
    return this.http.post(`${ADD_DETAILS}?userId=${id}`, { bloodgroup, gender });
  }

  getUserDetails(id):Observable<any>{
    return this.http.get(`${GET_USER_DETAILS}?id=${id}`);
  }

  getDoctorName(id):any{
    return this.http.get(`${GET_DOCTOR_NAME}?specialityId=${id}`);
  }

}
