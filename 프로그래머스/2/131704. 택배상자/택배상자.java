import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            } 
            if (order[idx] == i) {
                idx++;
                answer++;
            }
            else stack.push(i);
        }
        
        while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
        } 
        
        return answer;
    }
}