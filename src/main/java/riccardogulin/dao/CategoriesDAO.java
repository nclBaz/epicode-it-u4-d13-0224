package riccardogulin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import riccardogulin.entities.Category;
import riccardogulin.exceptions.NotFoundException;

import java.util.UUID;

public class CategoriesDAO {
	private final EntityManager em;

	public CategoriesDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Category category) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(category);
		transaction.commit();
		System.out.println("La categoria " + category.getName() + " è stata correttamente salvata nel db!");
	}

	public Category findById(String id) {
		Category category = em.find(Category.class, UUID.fromString(id));
		if (category == null) throw new NotFoundException(id);
		return category;
	}
}
