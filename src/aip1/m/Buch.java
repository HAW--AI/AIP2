package aip1.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "buch")
public class Buch {

	private int id;
	private String titel;
	private Set<Kurs> kurse = new HashSet<Kurs>();

	public Buch() {
	}

	public Buch(String titel) {
		this.titel = titel;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "buch_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	@ManyToMany(mappedBy = "buecher")
	public Set<Kurs> getKurse() {
		return kurse;
	}

	public void setKurse(Set<Kurs> kurse) {
		this.kurse = kurse;
	}
	public void addKurs(Kurs kurse) {
		this.kurse.add(kurse);
	}

}
