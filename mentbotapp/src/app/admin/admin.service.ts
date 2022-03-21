import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const AUTH_API = "http://localhost:8080/api/auth/";
const GET_USER_DETAILS = "http://localhost:8080/admin/v1/getusers";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" }),
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient, public router: Router) { }

  getAppointmentDetails(): Observable<any>{
    return this.http.get(AUTH_API);
  }

  getUserDetails():Observable<any>{
    return this.http.get(GET_USER_DETAILS);
  }

  updateUserDetails(id):Observable<any>{
    return this.http.post(AUTH_API,{id})
  }

  deleteAppointment(id):Observable<any>{
    return this.http.post(AUTH_API,{id})
  }

}
