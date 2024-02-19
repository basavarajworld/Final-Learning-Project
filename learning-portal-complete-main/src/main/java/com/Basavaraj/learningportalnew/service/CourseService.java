package com.Basavaraj.learningportalnew.service;

import java.util.List;

import com.Basavaraj.learningportalnew.dto.CourseDTO;
import com.Basavaraj.learningportalnew.entity.CourseEntity;

public interface CourseService {

	//AUTHOR
	//get all courses
	public List<CourseEntity> getAllCourses();

	//add courses
	CourseDTO addCourse(CourseDTO course);

	//delete courses
	void deleteCourse(Long courseId);

	//update course
	CourseDTO updateCourse(CourseDTO course);

}
