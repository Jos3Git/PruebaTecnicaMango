package com.mango.exceptions;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageTest {

    @Test
    void gettersSetters() {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("message");
        errorMessage.setDate(LocalDateTime.of(1984,9,22,12,00));
        errorMessage.setStatus("status");

        assertEquals("message",errorMessage.getMessage());
        assertEquals(LocalDateTime.of(1984,9,22,12,00),errorMessage.getDate());
        assertEquals("status",errorMessage.getStatus());

    }

    @Test
    void canEqual() {
        ErrorMessage errorMessage1 = new ErrorMessage("status", LocalDateTime.of(1984,9,22,12,00),"message");
        ErrorMessage errorMessage2 = new ErrorMessage("status", LocalDateTime.of(1984,9,22,12,00),"message");

        assertTrue(errorMessage1.canEqual(errorMessage2));
    }

    @Test
    void testHashCode() {
        ErrorMessage errorMessage1 = new ErrorMessage("status", LocalDateTime.of(1984,9,22,12,00),"message");
        ErrorMessage errorMessage2 = new ErrorMessage("status", LocalDateTime.of(1984,9,22,12,00),"message");

        assertTrue(errorMessage1.hashCode()==errorMessage2.hashCode());
    }

    @Test
    void testToString() {
        ErrorMessage errorMessage = ErrorMessage.builder().build();
        assertNotNull(errorMessage.toString());
    }

    @Test
    void builder() {
        ErrorMessage errorMessage = ErrorMessage.builder().build();
        assertNotNull(errorMessage);
    }
}
