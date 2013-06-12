package aip2.m.Adapter;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 
 * @see http://www.rabbitmq.com/tutorials/tutorial-one-java.html
 */
public final class BankListener extends Thread {

	private final static String QUEUE_NAME = "hapsparToHes";
	private final static String SEP = "#HES#HES#";

	private boolean running = true;
	private BankAdapter callBackAdapter;

	private Connection connection;
	private Channel channel;
	private QueueingConsumer consumer;

	public BankListener(BankAdapter callBackAdapter) {
		this.callBackAdapter = callBackAdapter;
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try {
			this.connection = factory.newConnection();
			this.channel = connection.createChannel();

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);

			this.consumer = new QueueingConsumer(channel);
			channel.basicConsume(QUEUE_NAME, true, consumer);

		} catch (IOException e) {
			System.err.println("Unable to connect to our Bank via Messaging");
			// e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (running) {
			try {
				QueueingConsumer.Delivery delivery = consumer.nextDelivery();

				String message = new String(delivery.getBody());
				System.out.println(" [x] Received '" + message + "'");

				String[] splitMsg = message.split(SEP);
				int rechnungsNr = Integer.parseInt(splitMsg[1]);
				int betrag = Integer.parseInt(splitMsg[2]);
				callBackAdapter.eintreffendeUeberweisung(rechnungsNr, betrag);

			} catch (ShutdownSignalException | ConsumerCancelledException
					| InterruptedException | NullPointerException e) {
				System.err.println("Unable to receive from our Bank via Messaging");
				// e.printStackTrace();
				this.stopListener();
			}
		}
	}

	public void stopListener() {
		running = false;
		try {
			channel.close();
			connection.close();
		} catch (IOException | NullPointerException e) {
		}

	}
}
