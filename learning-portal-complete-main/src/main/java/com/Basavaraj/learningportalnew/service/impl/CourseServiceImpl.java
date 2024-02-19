package com.Basavaraj.learningportalnew.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Basavaraj.learningportalnew.dto.CourseDTO;
import com.Basavaraj.learningportalnew.entity.CourseEntity;
import com.Basavaraj.learningportalnew.mapper.CourseMapper;
import com.Basavaraj.learningportalnew.repository.CourseRepository;
import com.Basavaraj.learningportalnew.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private  CourseRepository courseRepository;


	@Override
	public List<CourseEntity> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public CourseDTO addCourse(CourseDTO course) {

		CourseEntity courseEntity = CourseMapper.populateCourse(course);
		CourseEntity resCourse = courseRepository.save(courseEntity);

		CourseDTO resCourseDTO = CourseMapper.courseEntityToDTO(resCourse);
		return resCourseDTO;
	}

	@Override
	public void deleteCourse(Long courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public CourseDTO updateCourse(CourseDTO course) {
		//checking if the course exists
		Optional<CourseEntity> existingCourse = courseRepository.findById(course.getCourseId());

		//if course exists
		if (existingCourse.isPresent()) {

			CourseEntity updatedCourse = CourseMapper.populateCourse(course);

			//saving the course
			CourseEntity changedCourse = courseRepository.save(updatedCourse);
			CourseDTO resCourseDTO = CourseMapper.courseEntityToDTO(changedCourse);

			return resCourseDTO;

		}
		//returning empty course
		return new CourseDTO();
	}

}
