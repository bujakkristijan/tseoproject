import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminShowProfessorOnCourseListComponent } from './admin-show-professor-on-course-list.component';

describe('AdminShowProfessorOnCourseListComponent', () => {
  let component: AdminShowProfessorOnCourseListComponent;
  let fixture: ComponentFixture<AdminShowProfessorOnCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminShowProfessorOnCourseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminShowProfessorOnCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
