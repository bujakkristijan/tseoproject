import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminShowStudentOnCourseListComponent } from './admin-show-student-on-course-list.component';

describe('AdminShowStudentOnCourseListComponent', () => {
  let component: AdminShowStudentOnCourseListComponent;
  let fixture: ComponentFixture<AdminShowStudentOnCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminShowStudentOnCourseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminShowStudentOnCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
