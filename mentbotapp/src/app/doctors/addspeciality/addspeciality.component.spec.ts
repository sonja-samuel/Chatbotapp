import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddspecialityComponent } from './addspeciality.component';

describe('AddspecialityComponent', () => {
  let component: AddspecialityComponent;
  let fixture: ComponentFixture<AddspecialityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddspecialityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddspecialityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
