////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
//////////////////////////////////////////////////////////////////// 

package it.unipd.mtss.business.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import it.unipd.mtss.model.User;

@RunWith(JUnit4.class)
public class Usertest {
    
    User user;

    @Before
    public void initialize() {
        user = new User("Mattia", "Brunello", LocalDate.of(1999, 1, 1));
    }
    
    @Test
    public void testGetName() {
        assertEquals("Mattia", user.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Brunello", user.getSurname());
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals(LocalDate.of(1999, 1, 1), user.getDateOfBirth());
    }
    
    @Test
    public void testIllegalDateOfBirth() {
        try {
            new User("Mattia", "Brunello", LocalDate.now().plusDays(10));
        }catch (IllegalArgumentException e) {
            assertEquals("La data di nascita deve essere precedente alla data odierna", e.getMessage());
        }
}
    
    @Test
    public void testNullDateOfBirth() {
        try {
            new User("Mattia", "Brunello", null);
        }catch(IllegalArgumentException e) {
            assertEquals("La data di nascita è null", e.getMessage());
        }
    }
    @Test
    public void underAge() {
                
            assertEquals(true,new User("Mattia", "Brunello", LocalDate.of(2004,5,19)).isMinor());
    }

}
