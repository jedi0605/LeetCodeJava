import java.util.*;

public class leetcode213 {
    public static void main(String[] args) {
        int[] testcase = new int[] { 4, 1, 2, 7, 5, 3, 1 };
        var test = rob2(testcase);
        System.out.println(test);
    }

    public static int rob2(int[] nums) {
        int[] chooseOne = new int[nums.length];
        System.arraycopy(nums, 0, chooseOne, 0, nums.length);
        chooseOne[0] = nums[0];
        if (chooseOne[0] > chooseOne[1])
            chooseOne[1] = nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (i == nums.length - 1) {
                chooseOne[i] = 0;
                break;
            }
            if (chooseOne[i] + chooseOne[i - 2] > chooseOne[i - 1])
                chooseOne[i] = chooseOne[i] + chooseOne[i - 2];
            else
                chooseOne[i] = chooseOne[i - 1];
        }
        int[] chooseTwo = new int[nums.length];
        System.arraycopy(nums, 0, chooseTwo, 0, nums.length);

        chooseTwo[0] = 0;
        chooseTwo[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (chooseTwo[i] + chooseTwo[i - 2] > chooseTwo[i - 1])
                chooseTwo[i] = chooseTwo[i] + chooseTwo[i - 2];
            else
                chooseTwo[i] = chooseTwo[i - 1];
        }
        int max1 = Arrays.stream(chooseOne).max().getAsInt();
        int max2 = chooseTwo[nums.length - 1];
        return Math.max(max1, max2);

    }
}
