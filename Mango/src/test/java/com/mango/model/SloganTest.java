package com.mango.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SloganTest {

	@Test
	void gettersSetters() {
		Slogan slogan= Slogan.builder().build();

		slogan.setId(1L);
		slogan.setSloganText("slogan");

		assertEquals(1L,slogan.getId());
		assertEquals("slogan",slogan.getSloganText());
	}

	@Test
	void testEquals() {
		Slogan s1= new Slogan(1L,"text",null);
		Slogan s2= new Slogan(1L,"text",null);

		assertTrue(s1.equals(s2));

	}

	@Test
	void canEqual() {
		Slogan s1= new Slogan(1L,"text",null);
		Slogan s2= new Slogan(1L,"text",null);

		assertTrue(s1.canEqual(s2));
	}

	@Test
	void testHashCode() {
		Slogan s1= new Slogan(1L,"text",null);
		Slogan s2= new Slogan(1L,"text",null);

		assertTrue(s1.hashCode()==s2.hashCode());
	}

	@Test
	void testToString() {
		Slogan s1= new Slogan();

		assertNotNull(s1.toString());
	}

	@Test
	void builder() {
		Slogan s1=Slogan.builder().build();

		assertNotNull(s1);
	}
}
