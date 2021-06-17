import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminShowPaymentForCourseListComponent } from './admin-show-payment-for-course-list.component';

describe('AdminShowPaymentForCourseListComponent', () => {
  let component: AdminShowPaymentForCourseListComponent;
  let fixture: ComponentFixture<AdminShowPaymentForCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminShowPaymentForCourseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminShowPaymentForCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
