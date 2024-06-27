package GeekForGeeks;
// https://practice.geeksforgeeks.org/problems/square-root/1/?category[]=Binary%20Search&category[]=Binary%20Search&page=1&query=category[]Binary%20Searchpage1category[]Binary%20Search

public class KillingSpree {

	static long killinSpree(long x) {
		// base case
		if (x == 0 || x == 1){
			return x;}
		System.out.println("hello world");
		long start = 1, end = x, ans = 0;
		int steps = 0;
		// binary search to find square root of a number
		while (start <= end) {
			steps++;
			long mid = (start + end) / 2;

			// if mid*mid == x, then mid is the required element
			if (mid * mid == x)
				ans = mid; 

			// if mid*mid < x, then iterate for upper half
			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			}
			// else, iterate for lower half
			else
				end = mid - 1;
		}
		System.out.println("root found");
		long squareRoot = ans;
		System.out.println("sqareroor"+ ans);
		long sum = 0;
		int maxNumer = 0;
		for (int i = 1; i <= squareRoot; i++) {
			System.out.println(sum + i * i);
			if ((sum + i * i) > x) {
				break;
			} else {
				sum = sum + i * i;
				maxNumer++;
			}
		}
		return maxNumer;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		killinSpree(4);
		long stopTime = System.nanoTime();
		double timediff =stopTime - startTime;
		System.out.println(timediff/1000/1000);
			
	}
}