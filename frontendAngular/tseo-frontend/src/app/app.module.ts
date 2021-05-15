import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { CreateStudentComponent } from './create-student/create-student.component';

import { UpdateStudentComponent } from './update-student/update-student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';

import { FormsModule } from '@angular/forms';
import { ProfessorListComponent } from './professor-list/professor-list.component';
import { CreateProfessorComponent } from './create-professor/create-professor.component';
import { UpdateProfessorComponent } from './update-professor/update-professor.component';
import { CourseListComponent } from './course-list/course-list.component';
import { UpdateCourseComponent } from './update-course/update-course.component';
import { CreateCourseComponent } from './create-course/create-course.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    StudentDetailsComponent,
    ProfessorListComponent,
    CreateProfessorComponent,
    UpdateProfessorComponent,
    CourseListComponent,
    UpdateCourseComponent,
    CreateCourseComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
