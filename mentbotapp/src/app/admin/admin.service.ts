import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const AUTH_API = "http://localhost:8080/api/auth/";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" }),
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient, public router: Router) { }

  getAppointmentDetails(): any{
    return this.http.get(AUTH_API);
  }

  getUserDetails():any{
    return this.http.get(AUTH_API);
  }

  updateUserDetails(id):any{
    return this.http.post(AUTH_API,{id})
  }

}
