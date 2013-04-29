package aip2.m;

import java.util.List;

public class D {

	/**
	 * Delete Everything
	 */
	public static void main(String[] args) {

		List<Student> students = HibernateUtil.getAll(new Student());
		List<Buch> buecher = HibernateUtil.getAll(new Buch());
		List<Kurs> kurse = HibernateUtil.getAll(new Kurs());

		for (Kurs kurs : kurse) {
			kurs.setTeilnehmer(null);
			kurs.setBuecher(null);
			HibernateUtil.update(kurs);
		}

		for (Buch buch : buecher) {
			buch.setKurse(null);
			HibernateUtil.delete(buch);
		}

		for (Student s : students) {
			s.setKurse(null);
			HibernateUtil.delete(s);
		}

		for (Object obj : kurse) {
			HibernateUtil.delete(obj);
		}
	}
}
