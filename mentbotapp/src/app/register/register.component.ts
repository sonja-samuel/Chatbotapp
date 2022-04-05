import { Component, OnInit } from "@angular/core";
import { AuthService } from "../_services/auth.service";
import { FormBuilder, Validators } from "@angular/forms";

@Component({
  selector: "app-dashboard",
  templateUrl: "register.component.html",
})
export class RegisterComponent {
  
  form = this.fb.group({
    firstname: ["", [Validators.required]],
    lastname: ["", [Validators.required]],
    username: ["", [Validators.required]],
    email: ["", [Validators.required]],
    password: ["", [Validators.required]],
    phonenum: ["", [Validators.required]],
    addressline: ["", [Validators.required]],
    state: ["", [Validators.required]],
    city: ["", [Validators.required]],
    country: ["", [Validators.required]],
    pincode: ["", [Validators.required]],
    role: ["", [Validators.required]],
  });
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = "";
  roles=[];



  constructor(
      private authService: AuthService, 
      private fb: FormBuilder
    ) {}

  onSubmit(): void {
    const firstname = this.form.get(['firstname'])!.value;
    const lastname = this.form.get(['lastname'])!.value;
    const username = this.form.get(['username'])!.value;
    const email = this.form.get(['email'])!.value;
    const password = this.form.get(['password'])!.value;
    const phonenum = this.form.get(['phonenum'])!.value;
    const addressline = this.form.get(['addressline'])!.value;
    const state = this.form.get(['state'])!.value;
    const city = this.form.get(['city'])!.value;
    const country = this.form.get(['country'])!.value;
    const pincode = this.form.get(['pincode'])!.value;
    const role = this.form.get(['role'])!.value;
    this.roles.push(role);
    this.authService.register(firstname,lastname,username,email,password,phonenum,addressline,city,state,country,pincode,this.roles)
      .subscribe(
        (data) => {
          console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
        },
        (err) => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
        }
      );
  }
}
