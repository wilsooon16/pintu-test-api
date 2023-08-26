package com.pintu.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pintu.assertion.UserAssertions;
import com.pintu.model.User;
import com.pintu.utils.Listener;
import com.pintu.utils.Utilities;

import io.restassured.RestAssured;

@Listeners(Listener.class)
public class UserPostConsistencyTest {

	Faker faker;
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@DataProvider(name = "userCountProviderPost")
	public Object[][] userCountProvider() {
		return new Object[30][0]; // 30 rows, no columns needed
	}

	@Test(dataProvider = "userCountProviderPost")
	public void testConsistency30PostRequest() {
		User userPayload = new User.Builder().title(faker.lorem().sentence()).body(faker.lorem().paragraph())
				.userId(faker.number().randomDigitNotZero()).build();

		User user = Utilities.postAndDeserialize("/posts", userPayload, User.class);

		UserAssertions.assertResponseContainsPayloadData(userPayload, user);
	}
}