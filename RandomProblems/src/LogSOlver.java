import java.math.BigInteger;

/***
 * Collatz 3x+1 
 */
public class LogSOlver {
	public static void main(String[] args) {
		BigInteger x = new BigInteger("11");
		int counter = 0;
		while (!powerOf2(x)) {
			System.out.println("counter: " + counter);
			System.out.println("x: " + x);
			System.out.println("*********");
			x = x.multiply(new BigInteger("3")).add(new BigInteger("1"));
			counter++;
			if(counter==10) {
				System.exit(0);
			}
		}
		System.out.println("counter: " + counter);
		System.out.println("x: " + x);

	}

	public static boolean powerOf2(BigInteger y) {
		int counter = 0;
		BigInteger x = y.divide(new BigInteger("1"));
		while (!x.equals(new BigInteger("1")) ) {
			System.out.println("counterPower2: "+counter);
			System.out.println("xPower2: "+x);
			if (x.mod(new BigInteger("2")).equals(new BigInteger("1"))) {
				return false;
			}
			x = x.divide(new BigInteger("2"));
			counter++;
			if(counter==10) {
				System.exit(0);
			}

		}
		return true;

	}

}
