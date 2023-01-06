public class leetcode416 {

    public static void main(String[] args) {
        int[] testcase = { 1, 5, 11, 5 };
        Boolean result = canPartition(testcase);
    }

    public static boolean canPartition(int[] nums) {
        // dp[i][s]:from the first i elements, if there is a method to pick some numbers
        // whose sim equals s.
        // I.no pick i. */ dp[i-1][s] == true => dp[i][s] = true
        // II.pick i. dp[i-1][s-num[i]] == true => dpdp[i][s] = true
        // >> dp[i][s] = dp[i-1][s] || (s-num[i]>0 && dp[i-1][s-num[i]])

        int length = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int x : nums) { // 遍歷物品
            boolean[] dp2 = new boolean[dp.length];
            System.arraycopy(dp, 0, dp2, 0, dp.length);
            for (int s = 0; s <= sum / 2; s++) // 遍歷總和
            {
                if (s - x >= 0 && dp2[s - x] == true)
                    dp[s] = true;
            }
        }
        return dp[sum / 2];
    }

}
