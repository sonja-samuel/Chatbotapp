import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'register.component.html'
})
export class RegisterComponent  implements OnInit{

    form: any= {
        firstname: null,
        lastname: null,
        username: null,
        email: null,
        password: null,
        phonenum: null,
        addressline: null,
        state: null,
        city: null,
        country: null,
        pincode:null,
        role: null

    };
    isSuccessful = false;
    isSignUpFailed= false;
    errorMessage= '';
    constructor(private authService: AuthService){}

  ngOnInit(): void {
      
  }
  onSubmit(): void{
      const {firstname,lastname,username,email, password,phonenum,addressline,city,state, country, pincode,role } = this.form;
      this.authService.register(firstname,lastname,username,email, password,phonenum,addressline,city,state, country, pincode,role).subscribe(
          data => {
              console.log(data);
              this.isSuccessful=true;
              this.isSignUpFailed= false;
          },
          err => {
              this.errorMessage=err.error.message;
              this.isSignUpFailed= true;
          }
      );
  }

}
