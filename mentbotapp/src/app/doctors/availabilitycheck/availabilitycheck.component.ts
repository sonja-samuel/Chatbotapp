import { Component, OnInit } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { ToastService } from "../../_services/toast.service";
import { DoctorService } from "../doctor.service";

@Component({
  selector: "app-availabilitycheck",
  templateUrl: "./availabilitycheck.component.html",
  styleUrls: ["./availabilitycheck.component.scss"],
})
export class AvailabilitycheckComponent implements OnInit {

  daysAvailable:any;

  addScheduleForm = this.fb.group({
    daysAvailable: [null, [Validators.required]],
    startTime: [null, [Validators.required]],
    endTime: [null, [Validators.required]]
  });

  time: Date = new Date();

  constructor(
    private toastService : ToastService,
    private doctorService: DoctorService, 
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {}

  addSchedule():void{
   
    const daysAvailable = this.addScheduleForm.get(['daysAvailable'])!.value;
    this.daysAvailable = JSON.stringify(daysAvailable);
    this.daysAvailable =  this.daysAvailable.replaceAll('"','');
    this.daysAvailable=this.daysAvailable.replaceAll('[', '')
    this.daysAvailable=this.daysAvailable.replaceAll(']', '')
    const startTime = this.addScheduleForm.get(['startTime'])!.value;
    const endTime = this.addScheduleForm.get(['endTime'])!.value;
    this.doctorService.addSchedule(this.daysAvailable,startTime,endTime).subscribe( () => {
        this.toastService.openSweetAlertToast('Success','Schedule Added Succesfully');
      },
      () => {
        this.toastService.openSweetAlertToast('Error','Something went wrong!');
      });
  }
}
