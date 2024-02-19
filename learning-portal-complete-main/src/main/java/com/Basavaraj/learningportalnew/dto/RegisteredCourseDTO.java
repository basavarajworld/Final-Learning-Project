package com.Basavaraj.learningportalnew.dto;

import com.Basavaraj.learningportalnew.entity.CourseEntity;
import com.Basavaraj.learningportalnew.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredCourseDTO {

	private Long registrationId;
	private UserEntity user;
	private CourseEntity course;
}
