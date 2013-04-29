package aip2.m;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public interface IKunde {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kunde_nr")
	public abstract int getNr();

	public abstract String getName();

	public abstract String getAdresse();

	@OneToMany(mappedBy = "kunde")
	public abstract HashSet<Angebot> getAngebote();

}