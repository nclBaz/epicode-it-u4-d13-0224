package riccardogulin.entities;

import jakarta.persistence.*;

import java.util.List;
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

	@OneToMany(mappedBy = "author") // <-- Così la relazione diventa bidirezionale
	private List<BlogPost> blogPostList;
	// La bidirezionalità mi serve per poter, dato un utente, risalire alla lista di tutti i blog che ha scritto


	public User() {
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public List<BlogPost> getBlogPostList() {
		return blogPostList;
	}

	public void setBlogPostList(List<BlogPost> blogPostList) {
		this.blogPostList = blogPostList;
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
				'}';
	}
	// ATTENZIONE! Se la relazione è bidirezionale ed inseriamo un riferimento
	// nel toString al document e nel toString del document un riferimento allo user,
	// otterremo come risultato uno STACKOVERFLOW ERROR!
}
