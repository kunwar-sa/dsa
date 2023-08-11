package P045CircularTour;

public class CircularTour {

	public static void main(String[] args) {

		int[] petrol = { 4, 6, 7, 4 };
		int[] distance = { 6, 5, 3, 5 };
		int ans = tour(petrol, distance);
		System.out.println(ans);
	}

	public static int tour(int petrol[], int distance[]) {

		int ans = -1;
		int n = petrol.length;
		int deficit = 0;
		int balance = 0;

		for (int i = 0; i < n; i++) {

			balance += petrol[i] - distance[i];

			if (balance < 0) {
				deficit += balance;
				ans = i + 1;
				balance = 0;
			}

		}

		if (deficit + balance > -1)
			return ans;

		return -1;

	}
}
