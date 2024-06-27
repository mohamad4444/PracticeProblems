import java.util.Arrays;
 
public class SumOf75 {
	public static int sumArray(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = arr[i] + sum*7;
		}
		return sum;
	}

	public static int multiply(int[] arr) {
		int sum = 1;
		for (int i = 0; i < arr.length; i++) {
			sum = arr[i] * sum;
		}
		return sum;
	}

	public static boolean checkArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 25)
				return true;
		}
		return false;

	}

	public static void sumOf(int n, int m) {
		int[] a = new int[m];
		int[] b = new int[n];
		int x = b.length - 1, y = b.length - 1;
		while (b[0] != 25) {
			while (b[y] != 25) {
				b[y]++;
				a[sumArray(b)% m]++;
			}
			a[sumArray(b)% m]++;
			while (b[y] == 25) {
				b[y] = 0;
				y = y - 1;
			}
			b[y] = b[y] + 1;
			y = b.length - 1;
			a[sumArray(b) % m]++;
		}
		System.out.println(Arrays.toString(a));
	}

	public static void multiplyOf(int n, int m) {
		int[] a = new int[m];
		int[] b = new int[n];
		int x = b.length - 1, y = b.length - 1;
		while (b[0] != 25) {
			while (b[y] != 25) {
				b[y]++;
				a[multiply(b) % m]++;
			}
			a[multiply(b) % m]++;
			while (b[y] == 25) {
				b[y] = 0;
				y = y - 1;
			}
			b[y] = b[y] + 1;
			y = b.length - 1;
			a[multiply(b) % m]++;
		}
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		sumOf(5, 100);
		//multiplyOf(4, 50);
	}

}
