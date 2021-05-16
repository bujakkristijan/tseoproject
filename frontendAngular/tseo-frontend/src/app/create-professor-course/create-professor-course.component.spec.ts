import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProfessorCourseComponent } from './create-professor-course.component';

describe('CreateProfessorCourseComponent', () => {
  let component: CreateProfessorCourseComponent;
  let fixture: ComponentFixture<CreateProfessorCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateProfessorCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateProfessorCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
