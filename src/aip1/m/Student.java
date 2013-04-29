package aip1.m;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

	private int id;
	protected String name;
	private Notenkonto notenkonto;
	private Set<Kurs> kurse = new HashSet<Kurs>();

	public Student() {

	}

	public Student(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public Notenkonto getNotenkonto() {
		return notenkonto;
	}

	public void setNotenkonto(Notenkonto notenkonto_Id) {
		this.notenkonto = notenkonto_Id;
	}

	@OneToMany
	public Set<Kurs> getKurse() {
		return kurse;
	}

	public void setKurse(Set<Kurs> kurse) {
		this.kurse = kurse;
	}
	
	public void addKurs(Kurs kurs){
		this.kurse.add(kurs);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
