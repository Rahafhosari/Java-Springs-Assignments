package com.java.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.courses.models.Course;
import com.java.courses.repositories.CourseRepository;
import com.java.courses.repositories.UserRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepo;
	private final UserRepository userRepo;


	public CourseService(CourseRepository courseRepo, UserRepository userRepo) {
		this.courseRepo = courseRepo;
		this.userRepo = userRepo;
	}
	
	//List of all Courses
	 public List<Course> allCourses() {
	        return courseRepo.findAll();
	    }
	 
	//Course by Id
	 public Course findCourse(Long id) { return courseRepo.findById(id).orElse(null); }
	 
	 //Create Course
	 public Course createCourse(Course c){ return courseRepo.save(c); }
	
	 //Update Course
	 public Course updateCourse(Course course) {return courseRepo.save(course);}
	 
	//Delete
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

}
