package com.pintu.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pintu.assertion.UserAssertions;
import com.pintu.model.InvalidUser;
import com.pintu.model.User;
import com.pintu.utils.Listener;
import com.pintu.utils.Utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(Listener.class)
public class UserPostNegativeTest {
	Faker faker;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		faker = new Faker();
	}

	@Test
	public void testInvalidPayloadStructure() {
		InvalidUser invalidUserPayload = new InvalidUser.Builder().title(faker.number().digit())
				.body(faker.number().digit()).userId(faker.ancient().god()).build();

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
		InvalidUser invalidUserPayload = new InvalidUser.Builder().title(faker.number().digit())
				.body(faker.number().digit()).userId(faker.ancient().god()).build();

		Response response = Utilities.putInvalid("/posts", invalidUserPayload);

		UserAssertions.assertRequestNotFound(response);

	}

	@Test
	public void testUserResponseWithNegativeUserIDPayload() {
		InvalidUser invalidUserPayload = new InvalidUser.Builder().title(faker.lorem().sentence())
				.body(faker.lorem().paragraph()).userId(faker.number().numberBetween(-2147483645, -1)).build();

		InvalidUser user = Utilities.postAndDeserialize("/posts", invalidUserPayload, InvalidUser.class);

		UserAssertions.assertResponseContainsPayloadData(invalidUserPayload, user);
	}

}
