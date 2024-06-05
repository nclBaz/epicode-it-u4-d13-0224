package riccardogulin.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "blogs")
public class BlogPost {
	@Id
	@GeneratedValue
	private UUID id;
	private String title;
	private String content;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;

	public BlogPost() {
	}

	public BlogPost(String title, String content, User author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BlogPost{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", author=" + author +
				'}';
	}
}
