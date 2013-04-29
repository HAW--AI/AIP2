package aip1.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "kurs")
public class Kurs {

	private int id;
	private String Titel;
	private Student teilnehmer;
	private Set<Buch> buecher = new HashSet<Buch>();

	public Kurs() {
	}

	public Kurs(String titel) {
		Titel = titel;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kurs_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return Titel;
	}

	public void setTitel(String titel) {
		Titel = titel;
	}

	@ManyToOne
	public Student getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(Student teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	@ManyToMany
	public Set<Buch> getBuecher() {
		return buecher;
	}

	public void setBuecher(Set<Buch> buecher) {
		this.buecher = buecher;
	}
	public void addBuch(Buch buch) {
		this.buecher.add(buch);
	}

}
