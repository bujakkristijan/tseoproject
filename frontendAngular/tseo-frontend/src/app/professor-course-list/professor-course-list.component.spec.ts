import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorCourseListComponent } from './professor-course-list.component';

describe('ProfessorCourseListComponent', () => {
  let component: ProfessorCourseListComponent;
  let fixture: ComponentFixture<ProfessorCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorCourseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
