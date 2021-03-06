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
import { MyAvailableTestListForCourseComponent } from './my-available-test-list-for-course/my-available-test-list-for-course.component';
import { MySignedUpTestListComponent } from './my-signed-up-test-list/my-signed-up-test-list.component';
import { StudentSignUpTestComponent } from './student-sign-up-test/student-sign-up-test.component';
import { ProfessorSignedUpTestListComponent } from './professor-signed-up-test-list/professor-signed-up-test-list.component';
import { ProfessorEvaluateUserTestComponent } from './professor-evaluate-user-test/professor-evaluate-user-test.component';
import { ProfessorMyEvaluatedTestListComponent } from './professor-my-evaluated-test-list/professor-my-evaluated-test-list.component';
import { StudentMyEvaluatedTestListComponent } from './student-my-evaluated-test-list/student-my-evaluated-test-list.component';
import { AdminShowStudentOnCourseListComponent } from './admin-show-student-on-course-list/admin-show-student-on-course-list.component';
import { AdminShowProfessorOnCourseListComponent } from './admin-show-professor-on-course-list/admin-show-professor-on-course-list.component';
import { AdminShowPaymentForCourseListComponent } from './admin-show-payment-for-course-list/admin-show-payment-for-course-list.component';
import { ProfessorUpdateTestComponent } from './professor-update-test/professor-update-test.component';


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
    MyAvailableTestListForCourseComponent,
    MySignedUpTestListComponent,
    StudentSignUpTestComponent,
    ProfessorSignedUpTestListComponent,
    ProfessorEvaluateUserTestComponent,
    ProfessorMyEvaluatedTestListComponent,
    StudentMyEvaluatedTestListComponent,
    AdminShowStudentOnCourseListComponent,
    AdminShowProfessorOnCourseListComponent,
    AdminShowPaymentForCourseListComponent,
    ProfessorUpdateTestComponent,


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
