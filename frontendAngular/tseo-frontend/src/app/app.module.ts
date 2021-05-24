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
import { ProfessorCourseListComponent } from './professor-course-list/professor-course-list.component';
import { CreateProfessorCourseComponent } from './create-professor-course/create-professor-course.component';
import { LoginComponent } from './login/login.component';
import { MyPaymentListComponent } from './my-payment-list/my-payment-list.component';
import { CreatePaymentComponent } from './create-payment/create-payment.component';
import { MyPayedCourseListComponent } from './my-payed-course-list/my-payed-course-list.component';
import { CreateStudentCourseComponent } from './create-student-course/create-student-course.component';
import { MySubscribedCourseListComponent } from './my-subscribed-course-list/my-subscribed-course-list.component';
import { AvailableCourseListComponent } from './available-course-list/available-course-list.component';
import { ProfessorMyCourseListComponent } from './professor-my-course-list/professor-my-course-list.component';
import { ProfessorCreateTestComponent } from './professor-create-test/professor-create-test.component';
import { ProfessorMyTestListComponent } from './professor-my-test-list/professor-my-test-list.component';


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
    ProfessorCourseListComponent,
    CreateProfessorCourseComponent,
    LoginComponent,
    MyPaymentListComponent,
    CreatePaymentComponent,
    MyPayedCourseListComponent,
    CreateStudentCourseComponent,
    MySubscribedCourseListComponent,
    AvailableCourseListComponent,
    ProfessorMyCourseListComponent,
    ProfessorCreateTestComponent,
    ProfessorMyTestListComponent,


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
