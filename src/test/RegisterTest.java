package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Register;
import main.User;

public class RegisterTest {
	private ArrayList<User> users;
	
	@Before
	public void initUsers() {
		users = new ArrayList<>();
		users.add(new User("Endra", "endra@binus.ac.id", "12345"));
		users.add(new User("Fajar", "fajar@binus.ac.id", "abced"));
	}
	
	@Test
	public void testValidRegister() {
		Register register = new Register(users, "Tobby", "tobby@binus.ac.id", "00000");
		assertTrue(register.isSuccess());
	}
	
	@Test
	public void testInvalidRegister() {
		Register register = new Register(users, "Endra", "fajar@binus.ac.id", "12345");
		assertFalse(register.isSuccess());
	}
	
	@After
	public void clearUsers() {
		users.clear();
		users = null;
	}
	
}
