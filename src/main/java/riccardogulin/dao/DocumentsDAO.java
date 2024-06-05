package riccardogulin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import riccardogulin.entities.Document;
import riccardogulin.exceptions.NotFoundException;

import java.util.UUID;

public class DocumentsDAO {
	private final EntityManager em;

	public DocumentsDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Document document) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(document);
		transaction.commit();
		System.out.println("Il documento " + document.getCode() + " è stato correttamente salvato nel db!");
	}

	public Document findById(String id) {
		Document document = em.find(Document.class, UUID.fromString(id));
		if (document == null) throw new NotFoundException(id);
		return document;
	}

	public void findByIdAndDelete(String id) {
		Document found = this.findById(id);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(found);
		transaction.commit();
		System.out.println("Il documento " + found.getCode() + " è stato correttamente eliminato dal db!");
	}
}
