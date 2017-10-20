package fifth_lab;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

class ChatSession extends Thread {
	private Endpoint client;
	private PrintWriter send;
	private Scanner recv;

	public ChatSession(Endpoint client) throws IOException {
		this.client = client;
		Socket s = new Socket(client.getAddress(), client.getPort());
		send = new PrintWriter(s.getOutputStream());
		recv = new Scanner(s.getInputStream());
	}

	public ChatSession(Endpoint client, Socket s) throws IOException {
		this.client = client;
		send = new PrintWriter(s.getOutputStream());
		recv = new Scanner(s.getInputStream());
	}

	public void sendMessage(String message) {
		send.println(message);
	}

	public String receiveMessage() {
		return recv.nextLine();
	}

	public Endpoint getEndpoint() {
		return client;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(String.format("[%s]: %s", client, recv.nextLine()));
		}
	}
}