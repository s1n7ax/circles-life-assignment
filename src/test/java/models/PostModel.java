package models;

/**
 * PostModel
 */
public class PostModel {

	private transient int id;
	private String title;
	private String body;
	private int userId;

	public PostModel(final String title, final String body, final int userId) {
		this.title = title;
		this.body = body;
		this.userId = userId;
	}

	public PostModel(final int id, final String title, final String body, final int userId) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(final int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PostModel [body=" + body + ", id=" + id + ", title=" + title + ", userId=" + userId + "]";
	}

}
