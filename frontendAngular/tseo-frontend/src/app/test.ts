import { Course } from "./course";
import { User } from "./user";

export class Test {

  id: number;
  title: string;
  description: string;
  dateCreated: Date;
  maxPoints: number;
  course: Course;
  user: User;

}
