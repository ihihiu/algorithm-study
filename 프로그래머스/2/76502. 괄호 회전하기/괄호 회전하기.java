import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int N = s.length();
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack;
        
        for (int i = 0; i < N; i++) {
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
            stack = new Stack<>();
            for (int j = 0; j < N; j++) {
                if (sb.charAt(j) == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else if (sb.charAt(j) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else if (sb.charAt(j) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(sb.charAt(j));
                }
            }
            if (stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}