import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorCreateTestComponent } from './professor-create-test.component';

describe('ProfessorCreateTestComponent', () => {
  let component: ProfessorCreateTestComponent;
  let fixture: ComponentFixture<ProfessorCreateTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorCreateTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorCreateTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
