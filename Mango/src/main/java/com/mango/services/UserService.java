package com.mango.services;


import com.mango.dtos.UserDto;

import java.util.List;

public interface UserService{
    List<UserDto> finalAll();

    UserDto findById(Long id);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void deleteById(Long id);

	UserDto findByUser(UserDto userDto);
}
