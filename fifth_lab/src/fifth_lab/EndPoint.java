package fifth_lab;import java.net.InetAddress;
import java.net.UnknownHostException;

class Endpoint {
	private int port;
	private InetAddress ip;

	public Endpoint(InetAddress ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	// address may be "10.0.0.1:8080" or "xxx.inf.elte.hu:8000"
	public Endpoint(String address) throws UnknownHostException {
		String[] parts = address.split(":");
		if (parts.length == 2) {
			ip = InetAddress.getByName(parts[0]);
			port = Integer.parseInt(parts[1]);
		} else {
			throw new IllegalArgumentException("Illegal address: " + address);
		}
	}

	public int getPort() {
		return port;
	}

	public InetAddress getAddress() {
		return ip;
	}

	@Override
	public boolean equals(Object o) {
		if (getClass().equals(o.getClass())) {
			Endpoint e = (Endpoint) o;
			return ip.equals(e.ip) && port == e.port;
		}
		return false;
	}
}