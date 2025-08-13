package P061MergeSortedArrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m - 1;
        int b = n - 1;
        int index = (m + n) - 1;

        while (b != -1) {

            if (a >= 0 && nums1[a] > nums2[b]) {
                nums1[index] = nums1[a];
                a--;
            } else {
                nums1[index] = nums2[b];
                b--;
            }
            index--;
        }
    }

}
