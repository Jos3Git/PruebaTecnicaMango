package com.mango.dtos;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {


	@Test
	void getterSetterTest() {
		UserDto user=UserDto.builder().build();

		user.setId(1L);
		user.setName("name");
		user.setLastName("lastname");
		user.setAddress("address");
		user.setCity("city");
		user.setEmail("email");

		assertEquals(1L,user.getId());
		assertEquals("name",user.getName());
		assertEquals("lastname",user.getLastName());
		assertEquals("address",user.getAddress());
		assertEquals("city",user.getCity());
		assertEquals("email",user.getEmail());

	}

	@Test
	@DisplayName("equals devuelve true al ser iguales")
	void test1Equals() {
		UserDto user1= new UserDto(1L,"name","lastname","address","city","email",null);
		UserDto user2= new UserDto(1L,"name","lastname","address","city","email",null);

		assertTrue(user1.equals(user2));
	}

	@Test
	@DisplayName("equals devuelve false al no ser iguales")
	void test2Equals() {
		UserDto user1= new UserDto(1L,"name","lastname","address","city","email",null);
		UserDto user2= new UserDto(2L,"name","lastname","address","city","email",null);

		assertFalse(user1.equals(user2));
	}

	@Test
	void canEqual() {
		UserDto user1= new UserDto(1L,"name","lastname","address","city","email",null);
		UserDto user2= new UserDto(1L,"name","lastname","address","city","email",null);

		assertTrue(user1.canEqual(user2));
	}


	@Test
	void testHashCode() {
		UserDto user1= new UserDto(1L,"name","lastname","address","city","email",null);
		UserDto user2= new UserDto(1L,"name","lastname","address","city","email",null);

		assertTrue(user1.hashCode()== user2.hashCode());
	}

	@Test
	void testToString() {
		UserDto user= new UserDto();

		assertNotNull(user.toString());
	}

	@Test
	void builder() {
		UserDto user=UserDto.builder().build();

		assertNotNull(user);
	}
}
