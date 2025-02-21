import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        if (n % 2 == 1) return 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                char now = s.charAt(j);
                if (now == '(' || now == '{' || now == '[') stack.push(now);
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if ((stack.peek() == '(' && now == ')') || (stack.peek() == '{' && now == '}') || (stack.peek() == '[' && now == ']')) {
                        stack.pop();
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            s = s.substring(1, n) + s.charAt(0);
            if (stack.isEmpty() && flag) answer++;
            
        }
        return answer;
    }
}