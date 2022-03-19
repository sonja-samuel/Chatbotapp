import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { PERFECT_SCROLLBAR_CONFIG } from 'ngx-perfect-scrollbar';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
import { NgbTimepickerModule, NgbModule , NgbTimeAdapter } from '@ng-bootstrap/ng-bootstrap'
import { IconModule, IconSetModule, IconSetService } from '@coreui/icons-angular';
import {  ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { authInterceptorProviders} from './_helpers/auth.interceptor';
import { TimepickerModule, } from 'ngx-bootstrap/timepicker';
import { FormsModule } from '@angular/forms';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};

import { AppComponent } from './app.component';

// Import containers
import { HomeComponent } from './home';

import { P404Component } from './error/404.component';
import { P500Component } from './error/500.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const APP_CONTAINERS = [
  HomeComponent
];

import {
  AppAsideModule,
  AppBreadcrumbModule,
  AppHeaderModule,
  AppFooterModule,
  AppSidebarModule,
  
 
} from '@coreui/angular';

// Import routing module
import { AppRoutingModule } from './app.routing';

// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts';
import { ChatbotComponent } from './patients/chatbot/chatbot.component';
import { UsermanageComponent } from './admin/usermanage/usermanage.component';
import { PatientsDashboardComponent } from './patients/patients-dashboard/patients-dashboard.component';
import { AddDetailsComponent } from './patients/add-details/add-details.component';
import { AddappointmentComponent } from './patients/addappointment/addappointment.component';
import { DocprofileComponent } from './doctors/docprofile/docprofile.component';
import { AdddetailComponent } from './doctors/adddetail/adddetail.component';
import { AddspecialityComponent } from './doctors/addspeciality/addspeciality.component';
import { AvailabilitycheckComponent } from './doctors/availabilitycheck/availabilitycheck.component';
import { DoctorsDashboardComponent } from './doctors/doctors-dashboard/doctors-dashboard.component';

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    NgbTimepickerModule,
    AppAsideModule,
    AppBreadcrumbModule.forRoot(),
    AppFooterModule,
    AppHeaderModule,
    AppSidebarModule,
    PerfectScrollbarModule,
    BsDropdownModule.forRoot(),
    TabsModule.forRoot(),
    ChartsModule,
    IconModule,
    IconSetModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    TimepickerModule.forRoot(),
    FormsModule,
    NgbModule,
  ],
  declarations: [
    AppComponent,
    ...APP_CONTAINERS,
    P404Component,
    P500Component,
    LoginComponent,
    RegisterComponent,
    ChatbotComponent,
    UsermanageComponent,
    PatientsDashboardComponent,
    AddDetailsComponent,
    AddappointmentComponent,
    DocprofileComponent,
    AdddetailComponent,
    AddspecialityComponent,
    AvailabilitycheckComponent,
    DoctorsDashboardComponent,

  ],
  providers: [
    IconSetService,
    authInterceptorProviders,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
