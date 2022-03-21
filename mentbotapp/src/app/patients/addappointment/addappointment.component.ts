import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PatientsService } from '../patients.service';

@Component({
  selector: 'app-addappointment',
  templateUrl: './addappointment.component.html',
  styleUrls: ['./addappointment.component.scss']
})
export class AddappointmentComponent implements OnInit {

  showAvailableSlots = false
  availableSlots : any;
  isSpecialitySelected = false;
  doctorNames :any;
  doctorId : any;
  docId : any;
  specId :any;


  addAppointmentForm = this.fb.group({
    dateOfAppointment: [null, [Validators.required]],
    speciality: [null, [Validators.required]],
    doctorName: [null, [Validators.required]],
    slots: [null, [Validators.required]],
});

  constructor(
    private patientService: PatientsService,
    private fb: FormBuilder,) { }

  ngOnInit(): void {
  }

  getAvailableSlots():void{
    const doctorName = this.addAppointmentForm.get(['doctorName'])!.value;
    const dateOfAppointment = this.addAppointmentForm.get(['dateOfAppointment'])!.value;
    this.doctorId = this.doctorNames.filter(item => {
        if(item.doctorName = doctorName){
            this.docId = item.doctorId;
        }
    }
    )
    this.showAvailableSlots = true;
    this.patientService.getAvailableSlot(this.docId,dateOfAppointment).subscribe(
      (value:any) => {
        this.availableSlots = value;
      }
    )
  }

  getDoctorDetails(event):void{
    this.patientService.getDoctorName(event).subscribe(
        (value:any) => {
            this.isSpecialitySelected = true;
            this.doctorNames = value;
        }
    );
  }

  getTime():void{
    //
  }

  addAppointment():void{
    const patient_id = window.sessionStorage.getItem('auth-id');
    const dateOfAppointment = this.addAppointmentForm.get(['dateOfAppointment'])!.value;
    const speciality = this.addAppointmentForm.get(['speciality'])!.value;
    const doctorName = this.addAppointmentForm.get(['doctorName'])!.value;
    const slots = this.addAppointmentForm.get(['slots'])!.value;
    this.patientService.addAppointment(dateOfAppointment,this.specId,this.docId,patient_id,slots).subscribe()
  }

}