import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyAvailableTestListForCourseComponent } from './my-available-test-list-for-course.component';

describe('MyAvailableTestListForCourseComponent', () => {
  let component: MyAvailableTestListForCourseComponent;
  let fixture: ComponentFixture<MyAvailableTestListForCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyAvailableTestListForCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyAvailableTestListForCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
