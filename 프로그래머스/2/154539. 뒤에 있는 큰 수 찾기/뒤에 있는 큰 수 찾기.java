import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        int max = numbers[n - 1];
        answer[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (numbers[i] >= max) {
                answer[i] = -1;
                max = numbers[i];
            }
            else if (numbers[i] < numbers[i + 1]) answer[i] = numbers[i + 1];
            else {
                int idx = i + 1;
                while (answer[idx] != -1) {
                    if (answer[idx] > numbers[i]) break;
                    idx++;
                }
                answer[i] = answer[idx];
            }
                    
        }
        return answer;
    }
}