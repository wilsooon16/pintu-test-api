package com.pintu.assertion;

import static org.testng.Assert.*;

import org.testng.Assert;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import com.pintu.model.InvalidUser;
import com.pintu.model.User;

import io.restassured.response.Response;

public class UserAssertions {

	public static void assertIncrementID(User[] users) {

		for (int i = 0; i < users.length; i++) {
			assertEquals(users[i].getId(), Integer.valueOf(i + 1));

		}
	}

	public static void assertUserArraySize(User[] users) {
		assertTrue(users.length > 0);
	}

	public static void assertMultipleUserProperties(User[] users) {
		for (User user : users) {
			assertUserProperties(user);
		}
	}

	public static void assertUserProperties(User user) {
		assertNotNull(user.getUserId());
		assertTrue(user.getUserId() instanceof Integer);

		assertNotNull(user.getId());
		assertTrue(user.getId() instanceof Integer);

		assertNotNull(user.getTitle());
		assertTrue(user.getTitle() instanceof String);

		assertNotNull(user.getBody());
		assertTrue(user.getBody() instanceof String);

	}

	public static void assertResponseContainsPayloadData(User payload, User response) {
		assertEquals(payload.getBody(), response.getBody());
		assertEquals(payload.getTitle(), response.getTitle());
		assertEquals(payload.getUserId(), response.getUserId());

	}

	public static void assertResponseContainsPayloadData(InvalidUser payload, InvalidUser response) {
		assertEquals(payload.getBody(), response.getBody());
		assertEquals(payload.getTitle(), response.getTitle());
		assertEquals(payload.getUserId(), response.getUserId());

	}

	public static void assertInternalServerError(Response response) {
		Assert.assertEquals(response.statusCode(), 500);

	}

	public static void assertRequestNotFound(Response response) {
		Assert.assertEquals(response.statusCode(), 404);

	}

	public static void assertUserIdsAscending(User[] users) {
		int previousUserId = -1; // Initialize with a value that is not possible for userId
		for (User user : users) {
			int currentUserId = user.getUserId();
			assertThat(currentUserId, greaterThanOrEqualTo(previousUserId));
			previousUserId = currentUserId;
		}
	}

}
