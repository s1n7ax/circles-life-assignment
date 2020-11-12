package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.client.utils.URIBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data_provider.JsonPlaceHolderDataProvider;
import io.restassured.http.ContentType;
import models.CommentModel;
import models.PostModel;

/**
 * JsonPlaceHoderTests
 */
public class JsonPlaceHoderTests {
	private final String SCHEME = "https";
	private final String HOST = "jsonplaceholder.typicode.com";

	@Test(dataProvider = "post-retrieve-data", dataProviderClass = JsonPlaceHolderDataProvider.class)
	public void verifyPostRetrival(final int id) {

		var uriBuilder = new URIBuilder().setScheme(SCHEME).setHost(HOST);
		final var response = given().get(uriBuilder.setPath("/posts/" + id).toString());

		response.then().assertThat().statusCode(200);

	}

	@Test(dataProvider = "post-creation-data", dataProviderClass = JsonPlaceHolderDataProvider.class)
	public void verifyPostCreation(final PostModel model) {
		final var json = new Gson().toJson(model);

		var uriBuilder = new URIBuilder().setScheme(SCHEME).setHost(HOST);
		final var response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(json).when()
				.post(uriBuilder.setPath("/posts").toString());

		response.then().assertThat().statusCode(201).body("title", equalTo(model.getTitle()))
				.body("body", equalTo(model.getBody())).body("userId", equalTo(model.getUserId()))
				.body("id", equalTo(model.getId()));
	}

	@Test(dataProvider = "post-update-data", dataProviderClass = JsonPlaceHolderDataProvider.class)
	public void verifyPostUpdate(final PostModel model) {

		final var json = new GsonBuilder().excludeFieldsWithModifiers().create().toJson(model);

		var uriBuilder = new URIBuilder().setScheme(SCHEME).setHost(HOST);
		final var response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(json).when()
				.put(uriBuilder.setPath("/posts/" + model.getId()).toString());

		response.then().assertThat().statusCode(200).body("title", equalTo(model.getTitle()))
				.body("body", equalTo(model.getBody())).body("userId", equalTo(model.getUserId()))
				.body("id", equalTo(model.getId()));

	}

	@Test(dataProvider = "post-delete-data", dataProviderClass = JsonPlaceHolderDataProvider.class)
	public void verifyPostDeletion(final int id) {

		var uriBuilder = new URIBuilder().setScheme(SCHEME).setHost(HOST);
		final var response = given().delete(uriBuilder.setPath("/posts/" + id).toString());

		response.then().assertThat().statusCode(200);

	}

	@Test(dataProvider = "comment-retrieve-data", dataProviderClass = JsonPlaceHolderDataProvider.class)
	public void verifyCommentRetrival(final int id) {

		var uriBuilder = new URIBuilder().setScheme(SCHEME).setHost(HOST);
		final var response = given().when()
				.get(uriBuilder.setPath("/comments").addParameter("postId", String.valueOf(id)).toString());

		final var comments = response.then().assertThat().statusCode(200).extract().as(CommentModel[].class);

		for (final CommentModel comment : comments)
			Assert.assertEquals(comment.getPostId(), id);
	}

	@Test(dataProvider = "not-existing-data", dataProviderClass = JsonPlaceHolderDataProvider.class)
	public void verifyNotExistingResourceAccess(final int id) {

		var uriBuilder = new URIBuilder().setScheme(SCHEME).setHost(HOST);
		final var response = given().when().get(uriBuilder.setPath("/posts/" + id).toString());

		response.then().assertThat().statusCode(404);

	}

	@Test(dataProvider = "malformed-data", dataProviderClass = JsonPlaceHolderDataProvider.class)
	public void verifyMalformedDataCreation(final String json) {

		var uriBuilder = new URIBuilder().setScheme(SCHEME).setHost(HOST);
		final var response = given().contentType(ContentType.JSON).body(json).when()
				.post(uriBuilder.setPath("/posts").toString());

		/**
		 * @TODO when the request contains malformed data, server should return 400 but
		 *       json place holder does not
		 */
		response.then().assertThat().statusCode(500);

	}

}
