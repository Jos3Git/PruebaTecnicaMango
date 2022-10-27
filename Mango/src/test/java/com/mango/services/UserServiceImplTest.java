package com.mango.services;

import com.mango.dtos.UserDto;
import com.mango.exceptions.UserNotFoundRuntimeException;
import com.mango.model.User;
import com.mango.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;

	@Test
	@DisplayName("findAll returns a list of userDto")
	void findAllTest1() {
		when (userRepository.findAll()).thenReturn(new ArrayList<User>());

		userService.finalAll();

		verify(userRepository).findAll();
	}

	@Test
	@DisplayName ("when parameter id is null throw a Exception ")
	void findByIdTest1() {
		assertThrows(IllegalArgumentException.class,()->userService.findById(null));
	}

	@Test
	@DisplayName ("when parameter id is not null and the value exists at BBDD return a userDto")
	void findByIdTest2() {
		when(userRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(User.builder()
			.id(1L)
			.name("nametest")
			.lastName("lastnametest")
			.address("address")
			.city("city")
			.email("email")
			.build()));

		UserDto userDto = userService.findById(1L);

		verify(userRepository).findById(Mockito.any());
		assertEquals(1L,userDto.getId());
		assertEquals("nametest",userDto.getName());
		assertEquals("lastnametest",userDto.getLastName());
		assertEquals("address",userDto.getAddress());
		assertEquals("city",userDto.getCity());
		assertEquals("email",userDto.getEmail());


	}

	@Test
	@DisplayName ("when parameter id is not null and the value doesn't exist at BBDD throw exception")
	void findByIdTest3() {
		when(userRepository.findById(any())).thenReturn(Optional.empty());

		assertThrows(UserNotFoundRuntimeException.class,()->userService.findById(1L));
		verify(userRepository).findById(any());

	}

	@Test
	@DisplayName ("when create throws a illegalargumentException")
	void createTest1() {

		assertThrows(IllegalArgumentException.class,()-> userService.create(UserDto.builder()
			.id(1L)
			.name("nametest")
			.lastName("lastnametest")
			.address("address")
			.city("city")
			.email("email")
			.build()));

	}

	@Test
	@DisplayName ("when create method creates a user Dto")
	void createTest2() {

		when (userRepository.save(Mockito.any())).thenReturn(User.builder().id(1L)
			.name("nametest")
			.lastName("lastnametest")
			.address("address")
			.city("city")
			.email("email")
			.build());

		UserDto userDto = userService.create(UserDto.builder()
			.name("nametest")
			.lastName("lastnametest")
			.address("address")
			.city("city")
			.email("email")
			.build());

		verify(userRepository).save(Mockito.any());

	}

	@Test
	@DisplayName ("when update throws a illegalargumentException")
	void updateTest1() {

		assertThrows(IllegalArgumentException.class,()-> userService.update(UserDto.builder()
			.id(null)
			.name("nametest")
			.lastName("lastnametest")
			.address("address")
			.city("city")
			.email("email")
			.build()));

	}

	@Test
	@DisplayName ("when update method updates a user Dto")
	void updateTest2() {

		when (userRepository.save(Mockito.any())).thenReturn(User.builder()
			.id(1L)
			.name("nametest")
			.lastName("lastnametest")
			.address("address")
			.city("city")
			.email("email")
			.build());

		UserDto userDto = userService.update(UserDto.builder()
			.id(1L)
			.name("nametest")
			.lastName("lastnametest")
			.address("address")
			.city("city")
			.email("email")
			.build());

		verify(userRepository).save(Mockito.any());

	}

	@Test
	@DisplayName("deleteById Throws a illegalargumentException")
	void deleteByIdTest1() {

		assertThrows(IllegalArgumentException.class,()->userService.deleteById(null));

	}

}
