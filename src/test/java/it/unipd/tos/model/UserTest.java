////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.business.TakeAwayGelateria;

public class UserTest {
	
	private User user;
	
	@Before 
	public void setup() {
        user = new User("Mario", "Rossi", 42);
    }
	
	@Test
	public void getFirstNameTest() {
		assertEquals("Mario",user.getFirstName());
	}
	
	@Test
	public void getSurnameTest() {
		assertEquals("Rossi",user.getSurname());
	}

	@Test
	public void getAgeTest() {
		assertEquals(42,user.getAge());
	}
}
