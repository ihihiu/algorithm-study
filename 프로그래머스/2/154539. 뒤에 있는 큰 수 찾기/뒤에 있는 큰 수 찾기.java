import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> idxs = new Stack<>();
        idxs.push(0);
        for (int i = 1; i < n; i++) {
            while (!idxs.isEmpty() && numbers[idxs.peek()] < numbers[i]) {
                answer[idxs.pop()] = numbers[i];
            }
            idxs.push(i);
        }
        
        return answer;
    }
}