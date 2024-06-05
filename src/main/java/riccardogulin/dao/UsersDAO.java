package riccardogulin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import riccardogulin.entities.User;
import riccardogulin.exceptions.NotFoundException;

import java.util.UUID;

public class UsersDAO {
	private final EntityManager em;

	public UsersDAO(EntityManager em) {
		this.em = em;
	}

	public void save(User user) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(user);
		transaction.commit();
		System.out.println("Lo user " + user.getLastName() + " è stato correttamente salvato nel db!");
	}

	public User findById(String id) {
		User user = em.find(User.class, UUID.fromString(id));
		if (user == null) throw new NotFoundException(id);
		return user;
	}

	public void findByIdAndDelete(String id) {
		User found = this.findById(id);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(found);
		transaction.commit();
		System.out.println("Lo user " + found.getLastName() + " è stato correttamente eliminato dal db!");
	}
}
