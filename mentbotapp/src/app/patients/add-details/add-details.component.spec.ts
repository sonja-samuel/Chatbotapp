import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDetailsComponent } from './add-details.component';

describe('AddDetailsComponent', () => {
  let component: AddDetailsComponent;
  let fixture: ComponentFixture<AddDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
