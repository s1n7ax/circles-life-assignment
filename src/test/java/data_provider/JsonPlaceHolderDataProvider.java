package data_provider;

import org.testng.annotations.DataProvider;

import models.PostModel;

/**
 * JsonPlaceHolderDataProvider
 */
public class JsonPlaceHolderDataProvider {

	@DataProvider(name = "post-creation-data")
	public PostModel[] getPostCreationData() {
		return new PostModel[] { new PostModel(101, "post 1", "post 1 body", 1),
				new PostModel(101, "post 2", "post 2 body", 2), new PostModel(101, "post 3", "post 3 body", 3),
				new PostModel(101, "post 4", "post 4 body", 4) };
	}

	@DataProvider(name = "post-update-data")
	public PostModel[] getPostUpdateData() {
		return new PostModel[] { new PostModel(1, "post 1", "post 1 body updated", 1),
				new PostModel(2, "post 2", "post 2 body updated", 2),
				new PostModel(3, "post 3", "post 3 body updated", 3),
				new PostModel(4, "post 4", "post 4 body updated", 4) };
	}

	@DataProvider(name = "post-retrive-data")
	public Integer[] getPostRetriveData() {
		return new Integer[] { 1, 2, 3, 4 };
	}

	@DataProvider(name = "post-delete-data")
	public Integer[] getPostDeleteData() {
		return new Integer[] { 1, 2, 3, 4 };
	}

	@DataProvider(name = "comment-retrive-data")
	public Integer[] getCommentRetrivalData() {
		return new Integer[] { 1, 2, 3, 4 };
	}

	@DataProvider(name = "not-existing-data")
	public Integer[] getNotExistingData() {
		return new Integer[] { 11111111, 22222222, 33333333, 44444444 };
	}

	@DataProvider(name = "malformed-data")
	public String[] getMalformedData() {
		return new String[] { "[}", "{name: user}", "'value': 123", "count=10" };
	}
}
