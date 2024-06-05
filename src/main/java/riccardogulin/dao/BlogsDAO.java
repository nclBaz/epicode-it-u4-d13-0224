package riccardogulin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import riccardogulin.entities.BlogPost;
import riccardogulin.exceptions.NotFoundException;

import java.util.UUID;

public class BlogsDAO {
	private final EntityManager em;

	public BlogsDAO(EntityManager em) {
		this.em = em;
	}

	public void save(BlogPost blogPost) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(blogPost);
		transaction.commit();
		System.out.println("Il blog " + blogPost.getTitle() + " è stato correttamente salvato nel db!");
	}

	public BlogPost findById(String id) {
		BlogPost blogPost = em.find(BlogPost.class, UUID.fromString(id));
		if (blogPost == null) throw new NotFoundException(id);
		return blogPost;
	}

	public void findByIdAndDelete(String id) {
		BlogPost found = this.findById(id);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(found);
		transaction.commit();
		System.out.println("Il blog " + found.getTitle() + " è stato correttamente eliminato dal db!");
	}
}
