package com.pintu.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pintu.assertion.UserAssertions;
import com.pintu.model.InvalidUser;
import com.pintu.utils.Listener;
import com.pintu.utils.Utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(Listener.class)
public class UserPostNegativeTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test
	public void testInvalidPayloadStructure() {
		InvalidUser invalidUserPayload = new InvalidUser.Builder().id("invalidId").title(123).body(true)
				.userId("invalidUserId").build();

		InvalidUser user = Utilities.postAndDeserialize("/posts", invalidUserPayload, InvalidUser.class);

		UserAssertions.assertResponseContainsPayloadData(invalidUserPayload, user);

	}

	@Test
	public void testServerErrors() {
		String invalidUserPayload = "{\"sdfsf\"}";
		Response response = Utilities.postInvalid("/posts", invalidUserPayload);

		UserAssertions.assertInternalServerError(response);
	}

	@Test
	public void testInvalidHTTPMethod() {
		InvalidUser invalidUserPayload = new InvalidUser.Builder().id("invalidId").title(123).body(true)
				.userId("invalidUserId").build();

		Response response = Utilities.putInvalid("/posts", invalidUserPayload);

		UserAssertions.assertRequestNotFound(response);

	}

}
