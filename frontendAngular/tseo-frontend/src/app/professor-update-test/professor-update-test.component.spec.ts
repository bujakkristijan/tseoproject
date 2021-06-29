import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorUpdateTestComponent } from './professor-update-test.component';

describe('ProfessorUpdateTestComponent', () => {
  let component: ProfessorUpdateTestComponent;
  let fixture: ComponentFixture<ProfessorUpdateTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorUpdateTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorUpdateTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
