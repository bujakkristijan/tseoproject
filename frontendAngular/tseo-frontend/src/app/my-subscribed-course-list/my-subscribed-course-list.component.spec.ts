import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MySubscribedCourseListComponent } from './my-subscribed-course-list.component';

describe('MySubscribedCourseListComponent', () => {
  let component: MySubscribedCourseListComponent;
  let fixture: ComponentFixture<MySubscribedCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MySubscribedCourseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MySubscribedCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
