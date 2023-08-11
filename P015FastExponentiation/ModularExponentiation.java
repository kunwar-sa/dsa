package P015FastExponentiation;

public class ModularExponentiation {

	public static void main(String[] args) {

		System.out.println(modularExponentiation(3, 1, 2));
	}

	public static int modularExponentiation(long x, long n, long m) {
		// Write your code here.

		long ans = 1;
		long pow = n;

		while (pow > 0) {
			if ((pow & 1) == 0) {
				x = (x * x) % m;
				pow /= 2;
			} else {
				ans = (ans * x) % m;
				pow -= 1;
			}
		}

		return (int) ans;
	}
}
