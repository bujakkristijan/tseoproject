import { Course } from "./course";
import { User } from "./user";

export class Payment {

  course: Course;
  user: User;
  datePayed: Date;
  amount: number;
  cardNumber: number;
  recipientNumber: number;
}
