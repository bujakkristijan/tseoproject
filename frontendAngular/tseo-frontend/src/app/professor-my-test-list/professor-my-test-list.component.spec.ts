import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorMyTestListComponent } from './professor-my-test-list.component';

describe('ProfessorMyTestListComponent', () => {
  let component: ProfessorMyTestListComponent;
  let fixture: ComponentFixture<ProfessorMyTestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorMyTestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorMyTestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
