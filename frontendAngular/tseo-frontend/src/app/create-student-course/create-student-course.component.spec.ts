import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateStudentCourseComponent } from './create-student-course.component';

describe('CreateStudentCourseComponent', () => {
  let component: CreateStudentCourseComponent;
  let fixture: ComponentFixture<CreateStudentCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateStudentCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateStudentCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
