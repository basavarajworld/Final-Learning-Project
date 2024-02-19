package com.Basavaraj.learningportalnew.mapper;

import com.Basavaraj.learningportalnew.dto.UserDTO;
import com.Basavaraj.learningportalnew.entity.UserEntity;

public class UserMapper {

	public static UserEntity populateUser(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(userDTO.getUsername());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setRole(userDTO.getRole());
		return userEntity;
	}

	public static UserDTO userEntitytoDTO(UserEntity user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		return userDTO;
	}

}
