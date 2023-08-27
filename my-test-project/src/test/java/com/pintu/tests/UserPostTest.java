package com.pintu.tests;

import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pintu.assertion.UserAssertions;
import com.pintu.model.User;
import com.pintu.utils.Listener;
import com.pintu.utils.Utilities;

import io.restassured.RestAssured;

@Listeners(Listener.class)
public class UserPostTest {
	Faker faker;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test
	public void testUserResponseDataType() {
		User userPayload = new User.Builder().title(faker.lorem().sentence()).body(faker.lorem().paragraph())
				.userId(faker.number().randomDigitNotZero()).build();

		User user = Utilities.postAndDeserialize("/posts", userPayload, User.class);

		UserAssertions.assertUserProperties(user);
	}
	
	@Test
	public void testUserResponseWithRegularPayload() {
		User userPayload = new User.Builder().title(faker.lorem().sentence()).body(faker.lorem().paragraph())
				.userId(faker.number().randomDigitNotZero()).build();

		User user = Utilities.postAndDeserialize("/posts", userPayload, User.class);

		UserAssertions.assertResponseContainsPayloadData(userPayload, user);
	}
	
	@Test
	public void testUserResponseWithLongTitle() {
		User userPayload = new User.Builder().title(faker.lorem().characters(1000000)).body(faker.lorem().paragraph())
				.userId(faker.number().randomDigitNotZero()).build();

		User user = Utilities.postAndDeserialize("/posts", userPayload, User.class);

		UserAssertions.assertResponseContainsPayloadData(userPayload, user);
	}
	
	@Test
	public void testUserResponseWithLongBody() {
		
		User userPayload = new User.Builder().title(faker.lorem().sentence()).body(faker.lorem().characters(1000000))
				.userId(faker.number().randomDigitNotZero()).build();

		User user = Utilities.postAndDeserialize("/posts", userPayload, User.class);

		UserAssertions.assertResponseContainsPayloadData(userPayload, user);
	}


	


}
