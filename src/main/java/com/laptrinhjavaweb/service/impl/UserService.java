package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserConverter userConverter = new UserConverter();
		UserEntity userEntity = userConverter.convertToEntity(userDTO);
		return null;
	}

}
