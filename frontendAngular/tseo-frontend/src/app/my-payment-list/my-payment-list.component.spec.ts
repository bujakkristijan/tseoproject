import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPaymentListComponent } from './my-payment-list.component';

describe('MyPaymentListComponent', () => {
  let component: MyPaymentListComponent;
  let fixture: ComponentFixture<MyPaymentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyPaymentListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPaymentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
