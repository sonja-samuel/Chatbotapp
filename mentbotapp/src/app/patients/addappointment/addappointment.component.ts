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
    this.showAvailableSlots = true;
    this.patientService.getAvailableSlot().subscribe(
      (value:any) => {
        this.availableSlots = value;
      }
    )
  }

  addAppointment():void{
    const dateOfAppointment = this.addAppointmentForm.get(['dateOfAppointment'])!.value;
    const speciality = this.addAppointmentForm.get(['speciality'])!.value;
    const doctorName = this.addAppointmentForm.get(['doctorName'])!.value;
    const slots = this.addAppointmentForm.get(['slots'])!.value;
    this.patientService.addAppointment(dateOfAppointment,speciality,doctorName,slots)
  }

}