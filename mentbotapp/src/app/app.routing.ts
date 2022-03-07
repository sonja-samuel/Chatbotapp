import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import { HomeComponent } from './home';

import { P404Component } from './error/404.component';
import { P500Component } from './error/500.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './_services/auth.guard';

export const routes: Routes = [
  {
    path: '404',
    component: P404Component,
    data: {
      title: 'Page 404'
    }
  },
  {
    path: '500',
    component: P500Component,
    data: {
      title: 'Page 500'
    }
  },
  {
    path: '',
    component: LoginComponent,
    data: {
      title: 'Login Page'
    }
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: {
      title: 'Register Page'
    }
  },
 
  {
    path: '',
    component: HomeComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'admin',
        loadChildren: () => import('./admin/admin-routing.module').then(m => m.AdminRoutingModule),canActivate:[AuthGuard],
      },
      {
        path: 'doctors',
        loadChildren: () => import('./doctors/doctors-routing.module').then(m => m.DoctorsRoutingModule),canActivate:[AuthGuard],
      },
      {
        path: 'patients',
        loadChildren: () => import('./patients/patients-routing.module').then(m => m.PatientsRoutingModule),canActivate:[AuthGuard],
      },
    ]
  },
  { path: '**', component: P404Component }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes , { useHash: false }) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
