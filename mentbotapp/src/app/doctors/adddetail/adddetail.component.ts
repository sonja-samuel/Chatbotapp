import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ToastService } from '../../_services/toast.service';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-adddetail',
  templateUrl: './adddetail.component.html',
  styleUrls: ['./adddetail.component.scss']
})
export class AdddetailComponent implements OnInit {

  addDetailsForm = this.fb.group({
    practingDate: [null, [Validators.required]],
    professionalStatement: [null, [Validators.required]],
    specializationIds: [null, [Validators.required]]
  });

  constructor(
    private toastService : ToastService,
    private doctorService: DoctorService,
    private fb: FormBuilder,
    ) { }

  ngOnInit(): void {
  }

  addDetails():void {
    const practingDate = this.addDetailsForm.get(['practingDate'])!.value;
    const professionalStatement = this.addDetailsForm.get(['professionalStatement'])!.value;
    const specializationIds = this.addDetailsForm.get(['specializationIds'])!.value;
    this.doctorService.addDetails(practingDate,professionalStatement,specializationIds).subscribe(
      () => {
        this.toastService.openSweetAlertToast('Success','Details Added Succesfully');
      },
      () => {
        this.toastService.openSweetAlertToast('Error','Something went wrong!');
      }
    )
  }

}
