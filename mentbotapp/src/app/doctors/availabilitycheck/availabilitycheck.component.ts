import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-availabilitycheck',
  templateUrl: './availabilitycheck.component.html',
  styleUrls: ['./availabilitycheck.component.scss']
})
export class AvailabilitycheckComponent implements OnInit {
    
    time: Date = new Date();

  constructor() { }

  ngOnInit(): void {
  }

}
