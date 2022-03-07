import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Router } from "@angular/router";

const AUTH_API = "http://localhost:8080/api/auth/";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" }),
};

@Injectable({
  providedIn: "root",
})
export class AuthService {
  constructor(private http: HttpClient, public router: Router) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + "signin",
      {
        username,
        password,
      },
      httpOptions
    );
  }

  register(
    firstname: string,
    lastname: string,
    username: string,
    email: string,
    password: string,
    phonenum: string,
    addressline: string,
    city: string,
    state: string,
    country: string,
    pincode: number,
    role: string
  ) {
    return this.http.post(
      AUTH_API + "signup",
      {
        firstname,
        lastname,
        username,
        email,
        password,
        phonenum,
        addressline,
        city,
        state,
        country,
        pincode,
        role,
      },
      httpOptions
    );
  }

  logout() {
    window.sessionStorage.removeItem("auth-token");
    window.sessionStorage.removeItem("auth-user");
    this.router.navigate(["/login"]);
  }
  
}
