package riccardogulin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import riccardogulin.dao.DocumentsDAO;
import riccardogulin.dao.UsersDAO;
import riccardogulin.entities.Document;
import riccardogulin.entities.User;

import java.time.LocalDate;

public class Application {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d13");

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		UsersDAO ud = new UsersDAO(em);
		DocumentsDAO dd = new DocumentsDAO(em);

		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

/*		ud.save(aldo);
		ud.save(giovanni);
		ud.save(giacomo);*/

		/*try {
			User fromDB = ud.findById("b09de8af-7d2d-4bca-af55-80fcee2891c0");
			System.out.println(fromDB);
		} catch (NotFoundException ex) {
			System.out.println(ex.getMessage());
		}*/

		// **************************************** 1 to 1 ************************************
		User aldoFromDB = ud.findById("b09de8af-7d2d-4bca-af55-80fcee2891c0");
		/*Document aldoDoc = new Document("123iuh32", LocalDate.now(), LocalDate.now().plusYears(5), "Italy", aldo);*/
		// Un errore molto tipico quando si imposta una relazione è quello di passare nel costruttore del nuovo oggetto (o anche in un setter)
		// l'oggetto da relazionare senza che questo faccia parte del Persistence Context. aldo in questo caso è un oggetto qualsiasi, esso
		// se non viene chiamato il metodo .save (che fa una persist) non fa parte del Persistence Context e quindi non potrà essere usato
		Document aldoDoc = new Document("123iuh32", LocalDate.now(), LocalDate.now().plusYears(5), "Italy", aldoFromDB);
		// Invece se io usassi aldoFromDb, che è il risultato di una find, esso andrebbe bene
		dd.save(aldoDoc);
	}
}
