package aip2.externeSysteme;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * HapSpar
 * 
 * @see http://www.rabbitmq.com/tutorials/tutorial-one-java.html
 */
public class HapSpar {

	private final static String QUEUE_NAME = "hapsparToHes";
	private final static String SEP = "#HES#HES#";

	/**
	 * Ueberweise
	 * 
	 * @param args rechnungsnr betrag
	 */
	public static void main(String[] args) {
		if (args.length == 2) {

			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			try {
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();

				channel.queueDeclare(QUEUE_NAME, false, false, false, null);
				String message = "ueberweisung" + SEP + args[0] + SEP + args[1];
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

				System.out.println(" [x] Sent '" + message + "'");

				channel.close();
				connection.close();

			} catch (IOException e) {
				System.err.println("Die HapSpar ist gerade geschlossen");
			}

		} else
			System.out.println("Usage HapSpar <rechnungsnr> <betrag>");
	}

	@Deprecated
	private static Map<Integer, int[]> zahlungen = new HashMap<Integer, int[]>();

	@Deprecated
	public static Map<Integer, int[]> getBuchungen() {
		return zahlungen;
	}

	@Deprecated
	public static boolean ueberweise(int betreff, int[] einzelUeberweisungen) {
		zahlungen.put(betreff, einzelUeberweisungen);
		return true;
	}

	@Deprecated
	public static boolean ueberweisungenAbgeholt() {
		zahlungen.clear();
		return true;
	}
}
