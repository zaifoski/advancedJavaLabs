package fifth_lab;import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

class ChatClient {
	public static void main(String[] args) {
		if (args.length == 1) {
			try {
				Endpoint client = new Endpoint(args[0]);
				ChatClient program = new ChatClient();
				program.run();
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + args[0]);
			}
		}
	}

	private List<ChatSession> sessions;
	private int listeningPort;

	public void listen(int port) throws IOException {
		ServerSocket server = new ServerSocket(port);
		while (true) {
			Socket s = server.accept();
			try {
				PrintWriter send = new PrintWriter(s.getOutputStream());
				Scanner recv = new Scanner(s.getInputStream());

				// send list of connected users
				StringJoiner sj = new StringJoiner(" ");
				for (ChatSession session : sessions)
					sj.add(session.getEndpoint().toString());
				send.println(sj.toString());      // example: "10.0.0.3:9000 10.0.0.4:9000"
	    
				int listeningPort = recv.nextInt();
	    
				InetAddress ip = s.getInetAddress();
				Endpoint e = new Endpoint(ip, listeningPort);
				ChatSession session = new ChatSession(e, s);
				sessions.add(session);
			} catch (IOException e) {
				// ignore user
			}
		}
	}

	public void run() {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			String message = keyboard.nextLine();
			for (ChatSession session : sessions) {
				session.sendMessage(message);
			}
		}
	}

	private boolean isAlreadyConnected(Endpoint client) {
		for (ChatSession session : sessions)
			if (session.getEndpoint().equals(client))
				return true;
		return false;
	}

	private void connectTo(Endpoint client) throws IOException {
		if (isAlreadyConnected(client))
			return;
		else {
			ChatSession session = new ChatSession(client);
			String[] clients = session.receiveMessage().split(" ");
			session.sendMessage(listeningPort + "");
			sessions.add(session);
			session.start();   // here we spawn a new thread

			for (String aClient : clients) {
				try {
					Endpoint e = new Endpoint(aClient);
					connectTo(e);
				} catch (UnknownHostException e) {
					// ignore user
				}
			}
		}	
	}
}