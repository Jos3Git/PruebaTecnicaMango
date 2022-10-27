package com.mango.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

	@Test
	void getterSetterTest() {
		User user=User.builder().build();

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
		User user1= new User(1L,"name","lastname","address","city","email",null);
		User user2= new User(1L,"name","lastname","address","city","email",null);

		assertTrue(user1.equals(user2));
	}

	@Test
	@DisplayName("equals devuelve false al no ser iguales")
	void test2Equals() {
		User user1= new User(1L,"name","lastname","address","city","email",null);
		User user2= new User(2L,"name","lastname","address","city","email",null);

		assertFalse(user1.equals(user2));
	}

	@Test
	void canEqual() {
		User user1= new User(1L,"name","lastname","address","city","email",null);
		User user2= new User(1L,"name","lastname","address","city","email",null);

		assertTrue(user1.canEqual(user2));
	}


	@Test
	void testHashCode() {
		User user1= new User(1L,"name","lastname","address","city","email",null);
		User user2= new User(1L,"name","lastname","address","city","email",null);

		assertTrue(user1.hashCode()== user2.hashCode());
	}

	@Test
	void testToString() {
		User user= new User();

		assertNotNull(user.toString());
	}

	@Test
	void builder() {
		User user=User.builder().build();

		assertNotNull(user);
	}
}
