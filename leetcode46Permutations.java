import java.util.*;

public class leetcode46Permutations {
    public static void main(String[] args) {
        int[] testcase = new int[] { 1, 2, 3 };
        permute(testcase);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
             for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                     continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(res, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
