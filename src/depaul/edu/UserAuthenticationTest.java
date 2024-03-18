package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class UserAuthenticationTest {
	
	private UserAuthentication userAuth;
	
	@Before
	public void setUp() {
		userAuth = new UserAuthentication();
	}

	@Test
	public void testValidLogin() {
		setUp();
	    assertTrue(userAuth.authenticateUser("user1", "password1"));
	    assertEquals("user1", userAuth.getCurrentUser());
	}

	@Test
	public void testInvalidUsername() {
		setUp();
	    assertFalse(userAuth.authenticateUser("invalidUser", "password1"));
	    assertNull(userAuth.getCurrentUser());
	}

	@Test
	public void testInvalidPassword() {
		setUp();
	    assertFalse(userAuth.authenticateUser("user1", "invalidPassword"));
	    assertNull(userAuth.getCurrentUser());
	}

	@Test
	public void testNullUsernameAndPassword() {
		setUp();
	    assertFalse(userAuth.authenticateUser(null, null));
	    assertNull(userAuth.getCurrentUser());
	}

	@Test
	public void testEmptyUsernameAndPassword() {
		setUp();
	    assertFalse(userAuth.authenticateUser("", ""));
	    assertNull(userAuth.getCurrentUser());
	}
	
}

