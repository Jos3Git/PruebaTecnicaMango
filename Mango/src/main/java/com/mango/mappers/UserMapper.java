package com.mango.mappers;


import com.mango.dtos.UserDto;
import com.mango.model.User;

import java.util.stream.Collectors;

public interface UserMapper {

    static User to(UserDto dto){
		if(dto!=null) {
			User user = User.builder()
				.id(dto.getId())
				.name(dto.getName())
				.lastName(dto.getLastName())
				.address(dto.getAddress())
				.city(dto.getCity())
				.email(dto.getEmail())
				.build();

			if (dto.getSlogans()!=null){
				user.setSlogans(dto.getSlogans().stream().map(slogan -> SloganMapper.to(slogan)).collect(Collectors.toList()));
			}
			return user;
		}
		return null;
	}

    static UserDto to(User ent){
		if (ent!=null) {
			UserDto userDto = UserDto.builder()
				.id(ent.getId())
				.name(ent.getName())
				.lastName(ent.getLastName())
				.address(ent.getAddress())
				.city(ent.getCity())
				.email(ent.getEmail())
				.build();

			if (ent.getSlogans()!=null){
				userDto.setSlogans(ent.getSlogans().stream().map(slogan -> SloganMapper.to(slogan)).collect(Collectors.toList()));
			}
			return userDto;
		}
		return null;
    }
}
