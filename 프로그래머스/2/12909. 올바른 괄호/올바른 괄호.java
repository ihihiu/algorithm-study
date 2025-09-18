import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '(') stack.push(now);
            else {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                }
                else stack.push(now);
            }
        }
        
        if (!stack.isEmpty()) return false;

        return true;
    }
}