package aip2.m.ProduktModul;

import java.io.Serializable;

public class ProduktTyp implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nr;

	private String name;

	ProduktTyp(int nr, String name) {
		super();
		this.nr = nr;
		this.name = name;
	}

	public int getNr() {
		return nr;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduktTyp other = (ProduktTyp) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProduktTyp [nr=" + nr + ", name=" + name + "]";
	}
}
