import { CreateProfessorComponent } from './create-professor/create-professor.component';
import { ProfessorListComponent } from './professor-list/professor-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentDetailsComponent } from './student-details/student-details.component';


const routes: Routes = [
  {path: 'students', component: StudentListComponent},
  {path: '', redirectTo: 'students', pathMatch: "full"},
  {path: 'create-student', component: CreateStudentComponent},
  {path: 'update-student/:id', component: UpdateStudentComponent},
  {path: 'student-details/:id', component: StudentDetailsComponent},
  {path: 'professors', component: ProfessorListComponent},
  {path: 'create-professor', component: CreateProfessorComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
