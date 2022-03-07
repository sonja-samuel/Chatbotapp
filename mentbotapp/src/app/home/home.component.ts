import {Component} from '@angular/core';
import { NavigationEnd, NavigationStart, Router } from '@angular/router';
import { navItems ,adminNavItems,docNavItems,patientNavItems} from '../_nav';
import { AuthService } from '../_services/auth.service';




@Component({
  selector: 'app-dashboard',
  templateUrl: './home.component.html'
})

export class HomeComponent {

    constructor(router:Router,private auth: AuthService){
        router.events
    .subscribe((event:NavigationEnd) => {
    //   console.log(event);
      if (event instanceof NavigationEnd) {
        const url=event.url.split("/")[1];
        if(url==="admin"){
            this.navItems=adminNavItems;

        }
        else if(url==="doctors"){
            this.navItems=docNavItems;
        }
        else{
            this.navItems=patientNavItems;
        }
        
    }
      
    });


    }



  public sidebarMinimized = false;
  public navItems = [];

  toggleMinimize(e) {
    this.sidebarMinimized = e;
  }

  logout(){
      this.auth.logout();
  }
}
