public class MergeSort {

    public static void main(String[] args) {

        int[] arr = { 8, 1, 7, 2, 9 };
        mergeSort(arr, 5);

        for (int x : arr) {
            System.out.println(x);
        }
    }

    public static void mergeSort(int[] arr, int n) {
        // Write your code here.
        int s = 0;
        int e = n - 1;

        sort(arr, s, e);

    }

    public static void sort(int[] arr, int s, int e) {
        if (arr.length == 1 || arr.length == 0)
            return;
        if (s >= e)
            return;
        int mid = s + (e - s) / 2;
        sort(arr, s, mid);
        sort(arr, mid + 1, e);

        merge(arr, s, e, mid);
    }

    public static void merge(int[] arr, int s, int e, int mid) {

        int[] arr1 = new int[mid + 1 - s];
        int[] arr2 = new int[e - mid];

        int k = s;
        int n1 = arr1.length;
        for (int i = 0; i < n1; i++)
            arr1[i] = arr[k++];

        int n2 = arr2.length;
        for (int i = 0; i < n2; i++) {

            arr2[i] = arr[k++];

        }

        int i = 0;
        int j = 0;
        k = s;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                arr[k++] = arr1[i++];
            else
                arr[k++] = arr2[j++];
        }

        while (i < n1)
            arr[k++] = arr1[i++];
        while (j < n2)
            arr[k++] = arr2[j++];

    }
}
