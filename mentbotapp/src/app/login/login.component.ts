import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { FormBuilder, Validators } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit{

    constructor(
        private authService: AuthService,
         private tokenStorage: TokenStorageService,
          private lb: FormBuilder,
          public router: Router){ }

    loginForm = this.lb.group({
        username: [null, [Validators.required]],
        password: [null, [Validators.required]]
    });
    isLoggedIn = false;
    isLoginFailed= false;
    errorMessage='';
    roles: any;

   
    ngOnInit(): void {
        if(this.tokenStorage.getToken()){
            this.isLoggedIn=true;
            this.roles=this.tokenStorage.getUser();
            if(this.roles.includes("ROLE_PATIENT")){
                    
                this.router.navigate(['/patients']);
            } else if(this.roles.includes("ROLE_DOCTOR")){
                this.router.navigate(['/doctors']);
            } else if(this.roles.includes("ROLE_ADMIN")){
                this.router.navigate(['/admin']);
            }
           


        }
    }
    login(): void{
        const username = this.loginForm.get(['username'])!.value;
        const password = this.loginForm.get(['password'])!.value;
        this.authService.login(username,password).subscribe(
            data => {
                this.tokenStorage.saveToken(data.token);
                this.tokenStorage.saveUser(data.roles);
                this.tokenStorage.saveUserId(data.id);
                this.isLoginFailed=false;
                this.isLoggedIn=true;
                this.roles=this.tokenStorage.getUser();
                if(this.roles.includes("ROLE_PATIENT")){
                    
                    this.router.navigate(['/patients']);
                } else if(this.roles.includes("ROLE_DOCTOR")){
                    this.router.navigate(['/doctors']);
                } else if(this.roles.includes("ROLE_ADMIN")){
                    this.router.navigate(['/admin']);
                }
               
            },
            err => {
                this.errorMessage=err.error.message;
                this.isLoginFailed=true;
                
            }

        );

    }
   
}
