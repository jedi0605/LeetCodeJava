import java.util.*;

public class leetcode125 {
    public static void main(String[] args) {
        String testcase = "A man, a plan, a canal: Panama";
        Boolean result = isPalindrome(testcase);
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.print(s);
        char[] vowelArray = s.toCharArray();
        String revertString = "";
        Stack<Character> stackChar = new Stack<>();

        for (int i = 0; i < vowelArray.length; i++) {
            stackChar.push(vowelArray[i]);
        }
        System.out.print(stackChar.size());
        for (int i = 0; i < vowelArray.length; i++) {
            revertString += stackChar.pop();
        }
        System.out.print(revertString);
        return s.equals(revertString);
    }
}
