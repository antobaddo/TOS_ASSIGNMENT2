////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;
	
    @Before 
	public void setup() {
        user = new User("MR1","Mario", "Rossi", 42);
    }
	
	@Test
	public void getIdTest() {
		assertEquals("MR1",user.getId());
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
