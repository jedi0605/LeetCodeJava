import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class leetcode740 {

    public static void main(String[] args) {
        int[] testcase = { 1, 1, 1, 2, 4, 5, 5, 5, 6 };
        System.out.println(deleteAndEarn(testcase));
    }

    public static int deleteAndEarn(int[] nums) {
        // Like house robber.
        // Getting hash table first to get the all number

        // count data.
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int total = dict.getOrDefault(nums[i], 0);
            if (total == 0) {
                dict.put(nums[i], nums[i]);
            } else
                dict.put(nums[i], total + nums[i]);
        }

        // discinc int array.
        int[] house = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(house);
        System.out.println(Arrays.asList(dict)); // method 1

        // int earn2 = 0;
        int earn1 = dict.get(house[0]);
        if (house.length == 1)
            return earn1;

        int earn2 = dict.get(house[1]);
        if (house[1] - 1 != house[0])
            earn2 += earn1;
        else
            earn2 = Math.max(earn1, earn2);

        if (house.length == 2)
            return Math.max(earn1, earn2);

        for (int i = 2; i < house.length; i++) {
            int current = dict.get(house[i]);
            if (house[i] - 1 != house[i - 1]) {
                current += earn2;
            } else
                current += earn1;

            // Shift earn1 earn2
            earn1 = earn2;
            earn2 = Math.max(earn2, current);
        }
        return earn2;

    }

}
