// package P059SortColors;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortColors {

    public static void sortColors2(int[] nums) {

        Map<Integer, Long> freq = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int index = 0;
        for (Map.Entry<Integer, Long> x : freq.entrySet()) {
            Arrays.fill(nums, index, index + x.getValue().intValue(), x.getKey());
            index += x.getValue().intValue();
        }

        for (int x : nums)
            System.out.print(x);
    }

    public static void sortColors(int[] nums) {

        int r = 0;
        int w = 0;
        int b = nums.length - 1;

        while (w <= b) {
            if (nums[w] == 0) {
                nums[w] = nums[w] ^ nums[r];
                nums[r] = nums[w] ^ nums[r];
                nums[w] = nums[w] ^ nums[r];
                w++;
                r++;
            } else if (nums[w] == 1) {
                w++;
            } else {
                nums[w] = nums[w] ^ nums[b];
                nums[b] = nums[w] ^ nums[b];
                nums[w] = nums[w] ^ nums[b];
                b--;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1, 2, 0, 1, 2, 0, 1, 0, 2, 0, 1, 2, 1, 0 };
        sortColors(nums);
        for (int x : nums)
            System.out.print(x);
    }

}
