import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocprofileComponent } from './docprofile.component';

describe('DocprofileComponent', () => {
  let component: DocprofileComponent;
  let fixture: ComponentFixture<DocprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
