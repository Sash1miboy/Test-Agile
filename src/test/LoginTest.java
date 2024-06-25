package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Login;
import main.User;

public class LoginTest {
	private ArrayList<User> users;

	@Before
	public void initUsers() {
		users = new ArrayList<>();
		users.add(new User("Endra", "endra@binus.ac.id", "12345"));
		users.add(new User("Fajar", "fajar@binus.ac.id", "abcde"));
	}
	
	@Test
	public void testValidLogin() {
		Login login = new Login(users, "fajar@binus.ac.id", "abcde");
		assertTrue(login.isSuccess());
	}

	@Test
	public void testInvalidLogin() {
		Login login = new Login(users, "fajar@binus.ac.id", "12345");
		assertFalse(login.isSuccess());
	}
	
	@Test
	public void testWrongInvalidLogin() { // Example Test Failure
		Login login = new Login(users, "fajar@binus.ac.id", "12345");
		assertTrue(login.isSuccess());
	}
	
	@After
	public void clearUsers() {
		users.clear();
		users = null;
	}
	
}
