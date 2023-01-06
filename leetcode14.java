import java.lang.foreign.ValueLayout.OfAddress;
import java.util.*;

public class leetcode14 {
    public static void main(String[] args) {
        String[] testcase = new String[] { "ab", "a" };
        String shortest = GetShortest(testcase);
        String test = Prefix(testcase,shortest);
    }

    private static String GetShortest(String[] testcase) {
        String result = testcase[0];
        for (int i = 0; i < testcase.length; i++) {
            if (testcase[i].length() < result.length()) {
                result = testcase[i];
            }
        }
        return result;
    }

    private static String Prefix(String[] testcase,String shortest) {
        String tmp = "";
        for (int i = 0; i < shortest.length(); i++) {
            if (testcase[0].length() == 0)
                return "";
            char prefix = testcase[0].charAt(i);
            for (int j = 0; j < testcase.length; j++) {
                if (testcase[j].charAt(i) != prefix) {
                    return tmp;
                }
            }
            tmp += prefix;
        }
        return tmp;
    }
}
