package com.Basavaraj.learningportalnew.dto;

import com.Basavaraj.learningportalnew.entity.CourseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

	private Long courseId;
	private String title;
	private String description;
	private Long price;
	private CourseEntity.Category category;
}
