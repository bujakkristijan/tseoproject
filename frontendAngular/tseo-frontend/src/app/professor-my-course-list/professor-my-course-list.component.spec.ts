import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorMyCourseListComponent } from './professor-my-course-list.component';

describe('ProfessorMyCourseListComponent', () => {
  let component: ProfessorMyCourseListComponent;
  let fixture: ComponentFixture<ProfessorMyCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorMyCourseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorMyCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
