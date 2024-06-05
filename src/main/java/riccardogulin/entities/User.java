package riccardogulin.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	private String firstName;
	private String lastName;

	@OneToOne(mappedBy = "user")
	private Document document;
	// Se inserisco @OneToOne anche su questo lato (NON E' OBBLIGATORIO)
	// la relazione diventa BIDIREZIONALE
	// Ciò significa che aggiungo una possibilità in più, ovvero che non solo
	// dal document posso reperire il proprietario di tale documento, ma anche
	// viceversa posso se ho letto l'utente dal db, risalire ai dati del suo
	// documento, semplicemente tramite getter
	// mappedBy serve per specificare il nome dell'attributo dell'altra classe a cui ci colleghiamo
	// N.B. mappedBy NON CREA NESSUNA NUOVA COLONNA NELLA TABELLA USER

	public User() {
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", document=" + document +
				'}';
	}
}
