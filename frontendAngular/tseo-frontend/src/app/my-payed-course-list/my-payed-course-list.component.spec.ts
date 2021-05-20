import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPayedCourseListComponent } from './my-payed-course-list.component';

describe('MyPayedCourseListComponent', () => {
  let component: MyPayedCourseListComponent;
  let fixture: ComponentFixture<MyPayedCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyPayedCourseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPayedCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
