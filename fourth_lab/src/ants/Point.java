package ants;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Point {

	public Point() {
	}

	public Point(int x, int y) {
		this.x = BigInteger.valueOf(x);
		this.y = BigInteger.valueOf(y);
	}

	public Point(BigInteger x, BigInteger y) {
		this.x = x;
		this.y = y;
	}

	private BigInteger x = BigInteger.ZERO;
	private BigInteger y = BigInteger.ZERO;

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public BigInteger getX() {
		return x;
	}

	public BigInteger getY() {
		return y;
	}

	public Point translate(int dx, int dy) {
		return new Point(x.add(BigInteger.valueOf(dx)), y.add(BigInteger.valueOf(dy)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Point)) {
			return false;
		}
		Point other = (Point) obj;
		return x.equals(other.x) && y.equals(other.y);
	}

	public Point stepInDirection(Point direction) {
		BigInteger xDiff = direction.x.subtract(x);
		BigInteger yDiff = direction.y.subtract(y);
		if (xDiff.abs().compareTo(yDiff.abs()) > 0) {
			return new Point(x.add(BigInteger.valueOf(xDiff.signum())), y);
		} else {
			return new Point(x, y.add(BigInteger.valueOf(yDiff.signum())));
		}
	}
	
	public List<Point> neighbours() {
		return Arrays.asList(new Point(x.add(BigInteger.ONE), y), new Point(x.subtract(BigInteger.ONE), y),
				new Point(x.add(BigInteger.ONE), y.add(BigInteger.ONE)),
				new Point(x.add(BigInteger.ONE), y.subtract(BigInteger.ONE)),
				new Point(x.subtract(BigInteger.ONE), y.add(BigInteger.ONE)),
				new Point(x.subtract(BigInteger.ONE), y.subtract(BigInteger.ONE)), new Point(x, y.add(BigInteger.ONE)),
				new Point(x, y.subtract(BigInteger.ONE)));
	}
}