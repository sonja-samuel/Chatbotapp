import { Component, OnInit } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { ToastService } from "../../_services/toast.service";
import { PatientsService } from "../patients.service";

@Component({
  selector: "app-add-details",
  templateUrl: "./add-details.component.html",
  styleUrls: ["./add-details.component.scss"],
})
export class AddDetailsComponent implements OnInit {
  bloodGroup:any;
  gender:any
  addDetailsForm = this.fb.group({
    bloodgroup: [null, [Validators.required]],
    gender: [null, [Validators.required]]
});
  constructor(
    private toastService : ToastService,
    private patientService: PatientsService,
    private fb: FormBuilder,) {}

  ngOnInit(): void {
  }

  addDetails(): void {
    const id = window.sessionStorage.getItem('auth-id');
    const bloodgroup = this.addDetailsForm.get(['bloodgroup'])!.value;
    const gender = this.addDetailsForm.get(['gender'])!.value;
    this.patientService.addPatientDetails(id,bloodgroup,gender).subscribe(
        () => {
            this.toastService.openSweetAlertToast('Success','Details Added Succesfully');
        },
        () => {
            this.toastService.openSweetAlertToast('Error','Something went wrong!');
        }
    );
  }
}
