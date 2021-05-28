import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorEvaluateUserTestComponent } from './professor-evaluate-user-test.component';

describe('ProfessorEvaluateUserTestComponent', () => {
  let component: ProfessorEvaluateUserTestComponent;
  let fixture: ComponentFixture<ProfessorEvaluateUserTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorEvaluateUserTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorEvaluateUserTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
