package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.services.CourseService;
@RestController
public class MyController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		
		return "welcome to courses application";
	}
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.courseService.getCourses();
		
	}
	// single course get
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
	
	return this.courseService.getCourse(Long.parseLong(courseId));
}	
		
	//Course add
		@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course) ;
	
	}
		
		// update request using put operation
		
		@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.courseService.updateCourse(course);
	}
		
		//delete course
		
		@DeleteMapping("/courses/{courseId}")
		public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
			try {
				this.courseService.deleteCourse(Long.parseLong(courseId));
				return new ResponseEntity<>(HttpStatus.OK);
				
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
}
