import { AdminShowPaymentForCourseListComponent } from './admin-show-payment-for-course-list/admin-show-payment-for-course-list.component';
import { AdminShowProfessorOnCourseListComponent } from './admin-show-professor-on-course-list/admin-show-professor-on-course-list.component';
import { AdminShowStudentOnCourseListComponent } from './admin-show-student-on-course-list/admin-show-student-on-course-list.component';
import { StudentMyEvaluatedTestListComponent } from './student-my-evaluated-test-list/student-my-evaluated-test-list.component';
import { ProfessorMyEvaluatedTestListComponent } from './professor-my-evaluated-test-list/professor-my-evaluated-test-list.component';
import { ProfessorEvaluateUserTestComponent } from './professor-evaluate-user-test/professor-evaluate-user-test.component';
import { ProfessorSignedUpTestListComponent } from './professor-signed-up-test-list/professor-signed-up-test-list.component';
import { StudentSignUpTestComponent } from './student-sign-up-test/student-sign-up-test.component';
import { MySignedUpTestListComponent } from './my-signed-up-test-list/my-signed-up-test-list.component';
import { MyAvailableTestListForCourseComponent } from './my-available-test-list-for-course/my-available-test-list-for-course.component';
import { ProfessorMyTestListComponent } from './professor-my-test-list/professor-my-test-list.component';
import { ProfessorCreateTestComponent } from './professor-create-test/professor-create-test.component';
import { ProfessorMyCourseListComponent } from './professor-my-course-list/professor-my-course-list.component';
import { AvailableCourseListComponent } from './available-course-list/available-course-list.component';
import { MySubscribedCourseListComponent } from './my-subscribed-course-list/my-subscribed-course-list.component';
import { CreateStudentCourseComponent } from './create-student-course/create-student-course.component';
import { MyPayedCourseListComponent } from './my-payed-course-list/my-payed-course-list.component';
import { CreatePaymentComponent } from './create-payment/create-payment.component';
import { MyPaymentListComponent } from './my-payment-list/my-payment-list.component';
import { LoginComponent } from './login/login.component';
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
  {path: '', redirectTo: 'login', pathMatch: "full"},
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
  {path: 'create-professor-course', component: CreateProfessorCourseComponent},
  {path: 'login', component: LoginComponent},
  {path: 'my-payment-list', component: MyPaymentListComponent},
  {path: 'create-payment', component: CreatePaymentComponent},
  {path: 'my-payed-course-list', component: MyPayedCourseListComponent},
  {path: 'create-student-course/:id', component: CreateStudentCourseComponent},
  {path: 'my-subscribed-course-list', component: MySubscribedCourseListComponent},
  {path: 'available-course-list', component: AvailableCourseListComponent},
  {path: 'professor-my-course-list', component: ProfessorMyCourseListComponent},
  {path: 'professor-create-test/:id', component: ProfessorCreateTestComponent},
  {path: 'professor-my-test-list', component: ProfessorMyTestListComponent},
  {path: 'my-available-test-list-for-course/:id', component: MyAvailableTestListForCourseComponent},
  {path: 'my-signed-up-test-list', component: MySignedUpTestListComponent},
  {path: 'student-sign-up-test/:id', component: StudentSignUpTestComponent},
  {path: 'professor-signed-up-test-list/:id', component: ProfessorSignedUpTestListComponent},
  {path: 'professor-evaluate-user-test/:id', component: ProfessorEvaluateUserTestComponent},
  {path: 'professor-my-evaluated-test-list', component: ProfessorMyEvaluatedTestListComponent},
  {path: 'student-my-evaluated-test-list', component: StudentMyEvaluatedTestListComponent},
  {path: 'admin-show-student-on-course-list/:id', component: AdminShowStudentOnCourseListComponent},
  {path: 'admin-show-professor-on-course-list/:id', component: AdminShowProfessorOnCourseListComponent},
  {path: 'admin-show-payment-for-course-list/:id', component: AdminShowPaymentForCourseListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
