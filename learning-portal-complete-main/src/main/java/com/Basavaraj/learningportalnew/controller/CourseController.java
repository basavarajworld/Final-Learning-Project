package com.Basavaraj.learningportalnew.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Basavaraj.learningportalnew.dto.CourseDTO;
import com.Basavaraj.learningportalnew.entity.CourseEntity;
import com.Basavaraj.learningportalnew.entity.UserEntity;
import com.Basavaraj.learningportalnew.entity.UserEntity.Role;
import com.Basavaraj.learningportalnew.service.CourseService;
import com.Basavaraj.learningportalnew.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private  CourseService courseService;
	@Autowired
	private  UserService userService;



	//GET COURSES
	@GetMapping("/getall")
	public List<CourseEntity> getAllCourses() {
		log.info("listing all courses");
		return courseService.getAllCourses();
	}

	//ADD COURSES
	@PostMapping("/add/{id}")
	public CourseDTO addCourse(@RequestBody CourseDTO course, @PathVariable Long id) {
		//finding the author from the passed user_id
		Optional<UserEntity> author = userService.getUser(id);

		//if user is present and the role is author
		if (author.isPresent() && (author.get().getRole() == Role.AUTHOR)) {
			log.info("course added");
			//add course
			return courseService.addCourse(course);
		}
		//return empty course
		return new CourseDTO();
	}

	//DELETE COURSES
	@DeleteMapping("/delete/{id}/{user_Id}")
	public void deleteCourse(@PathVariable Long id, @PathVariable Long user_Id) {
		//finding if the user is present 
		Optional<UserEntity> isAuthor = userService.getUser(user_Id);

		//if the user is present and the role is author
		if (isAuthor.isPresent() && (isAuthor.get().getRole() == Role.AUTHOR)) {
			//delete the course
			courseService.deleteCourse(id);
			log.info("course deleted");
		}
	}

	//UPDATE COURSES
	@PutMapping("/update/{user_Id}")
	public CourseDTO updateCourse(@RequestBody CourseDTO course, @PathVariable Long user_Id) {
		//finding if the user is present
		Optional<UserEntity> isAuthor = userService.getUser(user_Id);

		//if user is present and the role is author
		if (isAuthor.isPresent() && (isAuthor.get().getRole() == Role.AUTHOR)) {
			log.info("course updated");
			return courseService.updateCourse(course);
		}
		return new CourseDTO();
	}
}