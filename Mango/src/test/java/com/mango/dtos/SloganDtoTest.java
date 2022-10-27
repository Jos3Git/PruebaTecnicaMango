package com.mango.dtos;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SloganDtoTest {

	@Test
	void gettersSetters() {
		SloganDto slogan= SloganDto.builder().build();

		slogan.setId(1L);
		slogan.setSloganText("slogan");

		assertEquals(1L,slogan.getId());
		assertEquals("slogan",slogan.getSloganText());
	}

	@Test
	void testEquals() {
		SloganDto s1= new SloganDto(1L,"text",null);
		SloganDto s2= new SloganDto(1L,"text",null);

		assertTrue(s1.equals(s2));

	}

	@Test
	void canEqual() {
		SloganDto s1= new SloganDto(1L,"text",null);
		SloganDto s2= new SloganDto(1L,"text",null);

		assertTrue(s1.canEqual(s2));
	}

	@Test
	void testHashCode() {
		SloganDto s1= new SloganDto(1L,"text",null);
		SloganDto s2= new SloganDto(1L,"text",null);

		assertTrue(s1.hashCode()==s2.hashCode());
	}

	@Test
	void testToString() {
		SloganDto s1= new SloganDto();

		assertNotNull(s1.toString());
	}

	@Test
	void builder() {
		SloganDto s1=SloganDto.builder().build();

		assertNotNull(s1);
	}
}
