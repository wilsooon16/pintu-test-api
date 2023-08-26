package com.pintu.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pintu.assertion.UserAssertions;
import com.pintu.model.User;
import com.pintu.utils.*;

import io.restassured.RestAssured;
@Listeners(Listener.class)
public class UserGetTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test
	public void testGetUserArraySize() {
		User[] users = Utilities.getAndDeserialize("/posts", User[].class);
		UserAssertions.assertUserArraySize(users);
	}

	@Test
	public void testAssertIncrementID() {
		User[] users = Utilities.getAndDeserialize("/posts", User[].class);
		UserAssertions.assertIncrementID(users);
	}

	@Test
	public void testAssertAscendingUserID() {
		User[] users = Utilities.getAndDeserialize("/posts", User[].class);
		UserAssertions.assertUserIdsAscending(users);
	}

	@Test
	public void testGetUserDataType() {
		User[] users = Utilities.getAndDeserialize("/posts", User[].class);
		UserAssertions.assertMultipleUserProperties(users);

	}

}
