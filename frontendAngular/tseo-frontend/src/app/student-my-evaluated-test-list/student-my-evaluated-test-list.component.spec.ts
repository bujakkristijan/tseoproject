import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentMyEvaluatedTestListComponent } from './student-my-evaluated-test-list.component';

describe('StudentMyEvaluatedTestListComponent', () => {
  let component: StudentMyEvaluatedTestListComponent;
  let fixture: ComponentFixture<StudentMyEvaluatedTestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentMyEvaluatedTestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentMyEvaluatedTestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
