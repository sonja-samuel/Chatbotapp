import { INavData } from '@coreui/angular';

export const adminNavItems: INavData[] = [

  {
    name: 'Admin Dashboard',
    url: '/admin',
    icon: 'icon-puzzle',
},
    
{
        name: 'User Manage',
        url: 'admin/usermanage',
        icon: 'icon-user'
      
    },
    //   {
    //     name: 'Doctor manage',
    //     url: '/admin/doctormanage',
    //     icon: 'icon-puzzle'
    //   }
     
  
   
    ];
export const docNavItems: INavData[] = [
  {
    name: 'Doctor Dashboard',
    url: '/doctors',
    icon: 'icon-puzzle',
  },
        {
            name: 'Add Details',
            url: 'doctors/adddetails',
            icon: 'icon-pencil'
          },
          {
            name: 'Availability Check',
            url: 'doctors/availability',
            icon: 'icon-check'
          },
          {
            name: 'View Profile',
            url: 'doctors/docprofile',
            icon: 'icon-user'
          }
     
  
    ];

export const patientNavItems: INavData[] = [
  {
    name: 'Patients Dashboard',
    url: '/patients',
    icon: 'icon-puzzle',
  },
  {
            name: 'Patient Profile',
            url: 'patients/patientprofile',
            icon: 'icon-pencil'
          
},
          {
            name: 'Add Appointment',
            url: 'patients/addappointment',
            icon: 'icon-check'
          },
          {
            name: 'Chat With Me',
            url: 'patients/chat',
            icon: 'icon-user'
          },
       
     
  
    ];
    export const navItems: INavData[] = [];
 
  


