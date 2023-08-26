package com.pintu.utils;

import java.lang.reflect.Field;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Utilities {

	public static <T> T getAndDeserialize(String endpoint, Class<T> responseClass) {

		return RestAssured.given().when().get(endpoint).then().assertThat().statusCode(200)
				.contentType(ContentType.JSON).extract().as(responseClass);
	}

	public static <T> T postAndDeserialize(String endpoint, Object payload, Class<T> responseClass) {
		return RestAssured.given().contentType(ContentType.JSON).body(payload).when().post(endpoint).then().assertThat()
				.statusCode(201).contentType(ContentType.JSON).extract().as(responseClass);
	}
	
	public static Response putInvalid(String endpoint, Object payload) {
		
		Response response =  RestAssured.given().contentType(ContentType.JSON).body(payload).when().put(endpoint).then().assertThat()
				.contentType(ContentType.JSON).extract()
                .response();
		
		return response;
	}
	
	public static Response postInvalid(String endpoint, Object payload) {
		
		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post(endpoint).then()
				.extract()
                .response();
		
		return response;
	}
	
	

	
}
