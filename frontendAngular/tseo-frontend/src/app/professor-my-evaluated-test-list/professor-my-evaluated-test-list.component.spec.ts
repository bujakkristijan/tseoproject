import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorMyEvaluatedTestListComponent } from './professor-my-evaluated-test-list.component';

describe('ProfessorMyEvaluatedTestListComponent', () => {
  let component: ProfessorMyEvaluatedTestListComponent;
  let fixture: ComponentFixture<ProfessorMyEvaluatedTestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorMyEvaluatedTestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorMyEvaluatedTestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
