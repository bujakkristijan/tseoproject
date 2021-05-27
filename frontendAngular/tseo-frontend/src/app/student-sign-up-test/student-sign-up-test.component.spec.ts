import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentSignUpTestComponent } from './student-sign-up-test.component';

describe('StudentSignUpTestComponent', () => {
  let component: StudentSignUpTestComponent;
  let fixture: ComponentFixture<StudentSignUpTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentSignUpTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentSignUpTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
