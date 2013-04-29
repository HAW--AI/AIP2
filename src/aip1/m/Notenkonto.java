package aip1.m;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notenkonto")
public class Notenkonto {

	private int id;
	private double gesamtnote;
	private Student student;

	public Notenkonto() {
	}

	public Notenkonto(double gesamtnote) {
		this.gesamtnote = gesamtnote;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "notenkonto_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGesamtnote() {
		return gesamtnote;
	}

	public void setGesamtnote(double gesamtnote) {
		this.gesamtnote = gesamtnote;
	}

	@OneToOne()
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
