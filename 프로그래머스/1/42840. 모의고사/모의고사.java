import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int n = answers.length;
        int[] correct = new int[3];
        
        
        for (int i = 0; i < n; i++) {
            int ans = answers[i];
            if (a[i%5] == ans) correct[0]++;
            if (b[i%8] == ans) correct[1]++;
            if (c[i%10] == ans) correct[2]++;
        }
        
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, correct[i]);
        }
        
        for (int i = 0; i < 3; i++) {
            if (max == correct[i]) res.add(i + 1);
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
        
    }
}