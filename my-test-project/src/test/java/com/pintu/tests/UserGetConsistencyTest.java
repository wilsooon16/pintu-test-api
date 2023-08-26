package com.pintu.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pintu.assertion.UserAssertions;
import com.pintu.model.User;
import com.pintu.utils.Listener;
import com.pintu.utils.Utilities;

import io.restassured.RestAssured;

@Listeners(Listener.class)
public class UserGetConsistencyTest {

	@BeforeClass
	public void setup() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@DataProvider(name = "userCountProvider", parallel = true)
	public Object[][] userCountProvider() {
		return new Object[30][0]; // 30 rows, no columns needed
	}

	@Test(dataProvider = "userCountProvider")
	public void testConsistency30GetRequest() {
		User[] users = Utilities.getAndDeserialize("/posts", User[].class);
		UserAssertions.assertMultipleUserProperties(users);
		
	}
}