import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        if (n % 2 == 1) return 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            for (char x : s.toCharArray()) {
                if (x == '(' || x == '{' || x == '[') stack.push(x);
                else if (!stack.isEmpty()) {
                    if ((x == ')' && stack.peek() == '(' )
                        || (x == '}' && stack.peek() == '{')
                        || (x == ']') && stack.peek() == '[') {
                        stack.pop();
                    }
                    else stack.push(x);
                }
                else stack.push(x);
            }
            if (stack.isEmpty()) answer++;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
}