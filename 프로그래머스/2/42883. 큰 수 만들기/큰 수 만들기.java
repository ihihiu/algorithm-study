import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int N = number.length();
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            int num = number.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;
            } 
            stack.push(num);
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        for (int x : stack) answer += x;
        
        return answer;
    }
}