package P008SineWaveOf2DArray;

public class SineWave {

	public static void main(String[] args) {

	}

	public static int[] wavePrint(int arr[][], int nRows, int mCols) {
		// Write your code here.
		int[] ans = new int[nRows * mCols];
		int index = 0;
		for (int i = 0; i < mCols; i++) {
			if (i % 2 == 0) {
				int j = 0;
				while (j < nRows) {
					ans[index++] = arr[j][i];
					j++;
				}
			} else {
				int j = nRows - 1;
				while (j >= 0) {
					ans[index++] = arr[j][i];
					j--;
				}
			}
		}
		return ans;
	}

}
