import { Course } from "./course";
import { User } from "./user";

export class UserCourse {

  public id: number;
  public course: Course;
  public user: User;
  public dateAdded: Date;
}
