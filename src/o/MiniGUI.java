package o;

import java.util.Scanner;

public class MiniGUI {

	public static void main(String[] args) throws Exception {
		System.out.println("+-----------------------------+");
		System.out.println("|       AI A1  Mini GUI       |");
		System.out.println("+-----------------------------+");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		int auswahl = 0;
		
		/* Hauptmenü */
		while (auswahl != 4) {
			System.out.println("Hauptmenü:");
			System.out.println("1) Create");
			System.out.println("2) Update");
			System.out.println("3) Delete");
			System.out.println("4) Quit");
			System.out.print("Ihre Auswahl: ");
			
			try { auswahl = Integer.parseInt(scan.nextLine()); }
			catch (Exception e) {
				/* ok, versuchen wir es erneut */
				auswahl = 0;
				System.err.println("Ihre Eingabe konnte nicht gelesen werden!");
				continue;
			}
			
			if (auswahl == 1) {
				// Create
			}
		}
		
		scan.close();
	}
}
