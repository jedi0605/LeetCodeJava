import java.util.*;

public class leetcode198 {
    public static void main(String[] args) {
        int[] testcase = new int[] { 2, 7, 9, 3, 1 };
        var test = rob(testcase);
        System.out.println(test);
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return dp[1];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }

}
