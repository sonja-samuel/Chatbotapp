import { Component, OnInit } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { ToastService } from "../../_services/toast.service";
import { PatientsService } from "../patients.service";

@Component({
  selector: "app-addappointment",
  templateUrl: "./addappointment.component.html",
  styleUrls: ["./addappointment.component.scss"],
})
export class AddappointmentComponent implements OnInit {
  showAvailableSlots = false;
  availableSlots: any;
  isSpecialitySelected = false;
  doctorNames: any;
  doctorId: any;
  docId: any;
  specId: any;

  addAppointmentForm = this.fb.group({
    dateOfAppointment: [null, [Validators.required]],
    speciality: [null, [Validators.required]],
    doctorName: [null, [Validators.required]],
    slots: [null, [Validators.required]],
  });

  constructor(
    private patientService: PatientsService,
    private fb: FormBuilder,
    private toastService: ToastService
  ) {}

  ngOnInit(): void {}

  getAvailableSlots(): void {
    const doctorName = this.addAppointmentForm.get(["doctorName"])!.value;
    const dateOfAppointment = this.addAppointmentForm.get([
      "dateOfAppointment",
    ])!.value;
    this.doctorId = this.doctorNames.filter((item) => {
      if ((item.doctorName = doctorName)) {
        this.docId = item.doctorId;
      }
    });
    this.showAvailableSlots = true;
    this.patientService
      .getAvailableSlot(this.docId, dateOfAppointment)
      .subscribe((value: any) => {
        this.availableSlots = value;
      });
  }

  getDoctorDetails(event:number): void {
    this.specId = event;
    this.patientService.getDoctorName(event).subscribe((value: any) => {
      this.isSpecialitySelected = true;
      this.doctorNames = value;
    });
  }

  getTime(): void {
    //
  }

  addAppointment(): void {
    const dateOfAppointment = this.addAppointmentForm.get([
      "dateOfAppointment",
    ])!.value;
    const speciality = this.addAppointmentForm.get(["speciality"])!.value;
    const doctorName = this.addAppointmentForm.get(["doctorName"])!.value;
    const slots = this.addAppointmentForm.get(["slots"])!.value;
    const startTime = slots.split(",")[0];
    const endTime = slots.split(",")[1];
    this.patientService
      .addAppointment(
        dateOfAppointment,
        this.specId,
        this.docId,
        startTime,
        endTime
      )
      .subscribe(
        () => {
          this.toastService.openSweetAlertToast(
            "Success",
            "Appointment Added Succesfully"
          );
        },
        () => {
          this.toastService.openSweetAlertToast(
            "Error",
            "Something went wrong!"
          );
        }
      );
  }
}
