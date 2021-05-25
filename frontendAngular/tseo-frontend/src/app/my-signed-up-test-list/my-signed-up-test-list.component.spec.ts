import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MySignedUpTestListComponent } from './my-signed-up-test-list.component';

describe('MySignedUpTestListComponent', () => {
  let component: MySignedUpTestListComponent;
  let fixture: ComponentFixture<MySignedUpTestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MySignedUpTestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MySignedUpTestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
