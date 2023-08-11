package P014GCDIterative;

public class GcdIterative {

	public static void main(String[] args) {

		System.out.println(gcd(500, 125));
	}

	public static int gcd(int a, int b) {

		int ans = 0;
		if (a == 0)
			ans = b;
		if (b == 0)
			ans = a;

		while (a != b) {
			if (a > b)
				a -= b;
			if (b > a)
				b -= a;
			ans = a;
		}

		return ans;
	}

}
