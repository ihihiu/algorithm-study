import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (char x : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < x && cnt < k) {
                cnt++;
                stack.pop();
            }
            stack.push(x);
        }
        for (int i = 0; i < number.length() - k; i++) answer += stack.get(i);
        return answer;
    }
}