import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorSignedUpTestListComponent } from './professor-signed-up-test-list.component';

describe('ProfessorSignedUpTestListComponent', () => {
  let component: ProfessorSignedUpTestListComponent;
  let fixture: ComponentFixture<ProfessorSignedUpTestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorSignedUpTestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorSignedUpTestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
