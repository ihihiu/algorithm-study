import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > numbers[i]) {
                answer[i] = stack.peek();
            }
            stack.push(numbers[i]);
            
        }
        
        return answer;
    }
}