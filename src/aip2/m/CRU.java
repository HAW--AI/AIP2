package aip2.m;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * a
 * 
 * http://blog.sencide.com/2011/03/hibernate-tutorial-for-beginners.html
 * 
 */

public class CRU {

	public static void main(String[] args) {

		/**
		 * Create
		 */
		Student hans = addStudent("Hans");
		Student peter = addStudent("Peter");
		Student meier = addStudent("Meier");
		Student karl = addStudent("Karl");

		addNotenkontoTo(hans, 1);
		addNotenkontoTo(peter, 5);
		addNotenkontoTo(meier, 10);
		addNotenkontoTo(karl, 15);

		Kurs weben = addKurs("Weben");
		Kurs kleben = addKurs("Kleben");
		Kurs schweben = addKurs("Schweben");

		/**
		 * 1 zu n
		 */
		connectKursToStudent(weben, hans);
		connectKursToStudent(schweben, hans);

		connectKursToStudent(kleben, meier);

		Buch abc = addBuch("abc");
		Buch def = addBuch("def");

		/**
		 * n zu m
		 */
		connectBuchAndKurs(abc, weben);
		connectBuchAndKurs(abc, kleben);

		connectBuchAndKurs(def, weben);

		/**
		 * Read
		 */
		// Student student = getStudent(2);
		List<Student> students = searchStudentByName("Peter");
		System.out.println(students);
		Student student = students.get(0);
		/**
		 * Update
		 */
		student.setName("Peter1");
		HibernateUtil.update(student);

		/**
		 * Update2 Student Meier
		 */
		List<Student> students2 = searchStudentByName("Meier");
		int meierId = students2.get(0).getId();
		System.out.println(meierId);
		updateStudentName(meierId, "MeierMeier");

		/**
		 * Update Teilnehmer mit abc Buch -> Notenbonus
		 */
		for (Kurs kurs : abc.getKurse()) {
			Student teilnehmer = kurs.getTeilnehmer();
			Notenkonto nk = teilnehmer.getNotenkonto();
			nk.setGesamtnote(nk.getGesamtnote() + 100);
			HibernateUtil.update(nk);
		}

		/**
		 * Delete Student Karl
		 */
		// Student student1 = new Student();
		// student1.setId(4);
		List<Student> students3 = searchStudentByName("Karl");
		int karlId = students3.get(0).getId();
		HibernateUtil.delete(getStudent(karlId));

	}

	private static Student addStudent(String name) {
		Student student = new Student();
		student.setName(name);
		HibernateUtil.add(student);
		return student;
	}

	private static Notenkonto addNotenkontoTo(Student s, double gesamtnote) {
		Notenkonto notenkonto = new Notenkonto();
		notenkonto.setGesamtnote(gesamtnote);
		/**
		 * set relation on both ends
		 */
		s.setNotenkonto(notenkonto);
		notenkonto.setStudent(s);

		HibernateUtil.add(notenkonto);
		HibernateUtil.update(s);
		return notenkonto;
	}

	private static Kurs addKurs(String name) {
		Kurs kurs = new Kurs();
		kurs.setTitel(name);
		HibernateUtil.add(kurs);
		return kurs;
	}

	private static Buch addBuch(String titel) {
		Buch buch = new Buch();
		buch.setTitel(titel);
		HibernateUtil.add(buch);
		return buch;
	}

	private static void connectKursToStudent(Kurs kurs, Student s) {
		kurs.setTeilnehmer(s);
		s.addKurs(kurs);
		HibernateUtil.update(s);
		HibernateUtil.update(kurs);
	}

	private static void connectBuchAndKurs(Buch buch, Kurs kurs) {
		buch.addKurs(kurs);
		kurs.addBuch(buch);
		HibernateUtil.update(buch);
		HibernateUtil.update(kurs);
	}

	private static <T> Student getStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student s;
		try {

			s = (Student) session.get(Student.class, id);

			return s;

		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	private static List<Student> searchStudentByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			Criteria criteria = session.createCriteria(Student.class);

			criteria.add(Restrictions.ilike("name", name + "%"));

			return criteria.list();

		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	private static void updateStudentName(int id, String name) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String hqlUpdate = "update Student s set s.name = :newName where s.id = :oldId";
			session.createQuery(hqlUpdate).setString("newName", name)
					.setInteger("oldId", id).executeUpdate();

			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

	}

	// private static <T> T get(Class clas, int id) {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// T s;
	// try {
	// s = session.get(clas, id);
	// return s.asInstanceOf[clas];
	//
	// } catch (RuntimeException e) {
	// e.printStackTrace();
	// return null;
	// } finally {
	// session.flush();
	// session.close();
	// }
	// }

}