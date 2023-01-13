public class CountPrimes {

    public static void main(String[] args) {

        int n = 40;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {

        int ans = 0;
        boolean[] primes = new boolean[n];
        for (int i = 0; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                ans++;
                for (int j = 2 * i; j < n; j = j + i)
                    primes[j] = false;
            }

        }

        return ans;
    }
}
