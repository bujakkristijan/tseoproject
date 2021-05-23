package tseo.sf82015.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tseo.sf82015.model.Course;
import tseo.sf82015.model.Payment;
import tseo.sf82015.model.User;
import tseo.sf82015.model.UserCourse;
import tseo.sf82015.service.CourseService;
import tseo.sf82015.service.PaymentService;
import tseo.sf82015.service.UserCourseService;
import tseo.sf82015.service.UserService;
import tseo.sf82015.web.dto.CourseDTO;
import tseo.sf82015.web.dto.CourseWithSubscribeInfoDTO;
import tseo.sf82015.web.dto.UserDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired 
	CourseService courseService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired 
	UserService userService;
	
	@Autowired
	UserCourseService userCourseService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
		if (courseService.findOne(id) == null) {
			return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
		}	
		Course course = courseService.findOne(id);
	
		return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getCourses", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getCourses() {
		List<Course> courses = courseService.findAll();

		if (courses.equals(null))
			return new ResponseEntity<List<CourseDTO>>(HttpStatus.NOT_FOUND);
		
		List<CourseDTO> coursesDTO = new ArrayList<>();
		for (Course c : courses) {
			coursesDTO.add(new CourseDTO(c));
		}
		return new ResponseEntity<List<CourseDTO>>(coursesDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
		if(courseDTO == null) {
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
		Course course = new Course();
		
		course.setName(courseDTO.getName());
		course.setCode(courseDTO.getCode()); 
		course.setPrice(courseDTO.getPrice());
		course.setDescription(courseDTO.getDescription());
		
		course = courseService.save(course);
		
		if (course != null) {
			return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> edit(@RequestBody CourseDTO courseDTO) {
		Course course = courseService.findOne(courseDTO.getId()); 
		if (course == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		course.setName(courseDTO.getName());
		course.setCode(courseDTO.getCode()); 
		course.setPrice(courseDTO.getPrice());
		course.setDescription(courseDTO.getDescription());
		
		courseService.save(course);// proveriti zasto ne more student = ...
		
		return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CourseDTO> delete(@PathVariable Long id) {		
		Course course = courseService.findOne(id);
		
		if(course == null)
			return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
									
		courseService.delete(course);
		return new ResponseEntity<CourseDTO>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getMyPayedCourses", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getMyPayedCourses() {
		List<Course> courses = courseService.findAll();
		List<Payment> payments = paymentService.findAll();
		List<Payment> myPayments = new ArrayList<Payment>();
		List<Course> payedCourses = new ArrayList<Course>();
		List<UserCourse> userCourses = userCourseService.findAll();
		List<UserCourse> myUserCourses = new ArrayList<UserCourse>();
		//List<CourseWithSubscribeInfoDTO> courseWithSubscribeInfoDTOList = new ArrayList<CourseWithSubscribeInfoDTO>();
		//CourseWithSubscribeInfoDTO courseWithSubscribeInfoDTO = new CourseWithSubscribeInfoDTO();
		List<Course> payedCoursesAndNotSubscribed = new ArrayList<Course>();
		if (courses.equals(null))
			return new ResponseEntity<List<CourseDTO>>(HttpStatus.NOT_FOUND);
		
		//User user = userService.getCurrentUser();
		User user = userService.getLoggedUser();
		double sumPayed = 0;
		// uzimam moje paymente
		if(user.getRole().equals("STUDENT")) 
			for(Payment p : payments)
				if(p.getUser().getId() == user.getId()) {
					myPayments.add(p);
				}
		// proveravam da li je suma veca od cene kursa, ako jeste stavljam kurs u payed courses
		for(Course c: courses) {
			for(Payment p: myPayments) {
				if(c.getId() == p.getCourse().getId()) {
					sumPayed = sumPayed + p.getAmount();
					if(c.getPrice() <= sumPayed) {
						payedCourses.add(c);
					}
				}
			}
			sumPayed = 0;
		}
		
		/*for(Course c: payedCourses) {
			courseWithSubscribeInfoDTO.setCourse(c);
			courseWithSubscribeInfoDTO.setSubscribedInfo(false);
			courseWithSubscribeInfoDTOList.add(courseWithSubscribeInfoDTO);
		}
		
		for(UserCourse uc: userCourses) {
			for(CourseWithSubscribeInfoDTO cwsi: courseWithSubscribeInfoDTOList) {
				if(uc.getCourse().getId() == cwsi.getCourse().getId()) {
					cwsi.setSubscribedInfo(true);
				}
			}
		}
		*/
		//for(UserCourse uc: userCourses) {
		//	if(uc.getUser().getId() == user.getId()){
		//		myUserCourses.add(uc);
		//	}
		//}
		// uzimam sve moje user courseve
		for(UserCourse uc: userCourses) {
			if(uc.getUser().getId() == user.getId()) {
				myUserCourses.add(uc);
			}
		}
		// proveravam da li je vec prijavljen na kurs, ako jeste ne dodaje ga, da na frontu ne bi opet ispisivao taj kurs da moze da se subscribuje
		int subscribedAlready = 0;
		for(Course pc: payedCourses) {
			for(UserCourse muc: myUserCourses) {
				if(pc.getId() == muc.getCourse().getId() && muc.getUser().getId() == user.getId()) {
					subscribedAlready = 1;
				}
			}
			if(subscribedAlready == 0) {
				payedCoursesAndNotSubscribed.add(pc);
			}
			subscribedAlready = 0;
		}
		/*int AlreadyThere = 0;
		for(Course pc: payedCourses) {
			for(UserCourse muc: myUserCourses) {
				if(pc.getId() == muc.getCourse().getId()) {
					AlreadyThere = 1;
				}
			}
			if(AlreadyThere == 0) {
				payedCoursesAndNotSubscribed.add(pc);
			}
		}
		
		*/
		List<CourseDTO> payedCoursesDTO = new ArrayList<>();
		for (Course pc : payedCoursesAndNotSubscribed) {
			payedCoursesDTO.add(new CourseDTO(pc));
		}
		return new ResponseEntity<List<CourseDTO>>(payedCoursesDTO, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getMySubscribedCourses", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getMySubscribedCourses() {
		
		//User user = userService.getCurrentUser();
		User user = userService.getLoggedUser();
		
		List<UserCourse> userCourses = userCourseService.findAll();
		List<Course> courses = courseService.findAll();
		List<UserCourse> myUserCourses = new ArrayList<UserCourse>();
		List<Course> mySubscribedCourses = new ArrayList<Course>();
		List<CourseDTO> mySubscribedCoursesDTO = new ArrayList<CourseDTO>();
		//uzmimam moje usercourseve
		for(UserCourse uc: userCourses) {
			if(uc.getUser().getId() == user.getId()) {
				myUserCourses.add(uc);
				
			}
		}
		//uzimam courseve
		for(UserCourse muc: myUserCourses) {
			for(Course c: courses) {
				if(c.getId() == muc.getCourse().getId() && muc.getUser().getId() == user.getId()) {
					mySubscribedCourses.add(c);
				}
			}
		}
		//pretvaram u dto koji saljem na front
		for(Course mc: mySubscribedCourses) {
			mySubscribedCoursesDTO.add(new CourseDTO(mc));
		}
		
		
		
		
		return new ResponseEntity<List<CourseDTO>>(mySubscribedCoursesDTO, HttpStatus.OK);
	}

}
