package riccardogulin.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class Document {
	@Id
	@GeneratedValue
	private UUID id;
	private String code;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private String country;
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	// JoinColumn serve per identificare e personalizzare la chiave esterna
	// Nullable = false serve per far si che non sia possibile NON inserire un utente per il documento
	// Unique = true serve per garantire che non ci siano 2 documenti con lo stesso user
	private User user;
	// Se aggiungo un attributo che mi collega ad un'entity, NON posso
	// NON mettere un'annotazione per identificare la relazione tipo @OneToOne
	// Se non la metto, avrò un errore abbastanza poco comprensibile che non
	// mi lascerà avviare l'applicazione

	public Document() {
	}

	public Document(String code, LocalDate issueDate, LocalDate expirationDate, String country, User user) {
		this.code = code;
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.country = country;
		this.user = user;
	}

	public UUID getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Document{" +
				"id=" + id +
				", code='" + code + '\'' +
				", issueDate=" + issueDate +
				", expirationDate=" + expirationDate +
				", country='" + country + '\'' +
				", user=" + user +
				'}';
	}
}
