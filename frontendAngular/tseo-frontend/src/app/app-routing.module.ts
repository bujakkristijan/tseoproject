import { CreateProfessorCourseComponent } from './create-professor-course/create-professor-course.component';
import { ProfessorCourseListComponent } from './professor-course-list/professor-course-list.component';
import { UserCourse } from './user-course';
import { CreateCourseComponent } from './create-course/create-course.component';
import { UpdateCourseComponent } from './update-course/update-course.component';
import { CourseListComponent } from './course-list/course-list.component';
import { UpdateProfessorComponent } from './update-professor/update-professor.component';
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
  {path: 'create-professor', component: CreateProfessorComponent},
  {path: 'update-professor/:id', component: UpdateProfessorComponent},
  {path: 'courses', component: CourseListComponent},
  {path: 'update-course/:id', component: UpdateCourseComponent},
  {path: 'create-course', component: CreateCourseComponent},
  {path: 'professor-courses', component: ProfessorCourseListComponent},
  {path: 'create-professor-course', component: CreateProfessorCourseComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
