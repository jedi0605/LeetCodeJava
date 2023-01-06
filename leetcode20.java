import java.util.*;

public class leetcode20 {
    public static void main(String[] args) {

        String testCase = "[[[]";
        boolean result = isValid(testCase);
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> maps = new HashMap<>();
        maps.put('(', ')');
        maps.put('[', ']');
        maps.put('{', '}');
        boolean everPop = false;

        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == '(' || target == '[' || target == '{') {
                stack.push(target);
            } else {
                if(stack.size()==0)
                    return false;
                char revertBrackets = maps.get(stack.pop());
                if (target != revertBrackets)
                    return false;
            }
        }
        if(stack.size()!=0)
            return false;
        return true;
    }
}
