import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailabilitycheckComponent } from './availabilitycheck.component';

describe('AvailabilitycheckComponent', () => {
  let component: AvailabilitycheckComponent;
  let fixture: ComponentFixture<AvailabilitycheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailabilitycheckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailabilitycheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
