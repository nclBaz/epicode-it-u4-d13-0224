package riccardogulin.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	@ManyToMany(mappedBy = "categories")
	private List<BlogPost> blogPostList;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public List<BlogPost> getBlogPostList() {
		return blogPostList;
	}

	public void setBlogPostList(List<BlogPost> blogPostList) {
		this.blogPostList = blogPostList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
