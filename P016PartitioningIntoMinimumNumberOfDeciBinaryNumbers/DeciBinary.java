package P016PartitioningIntoMinimumNumberOfDeciBinaryNumbers;

class DeciBinary {

	public int minPartitions(String n) {

		char[] c = n.toCharArray();
		int ans = 0;
		for (char x : c) {
			if ((x - '0') > ans)
				ans = (x - '0');
		}
		return ans;
	}
}

/*
 * Leetcode Medium level question. saw hint coded myself approach medium code
 * very easy
 */