import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int x = 1; x <= Math.sqrt(yellow); x++) {
            if (yellow % x != 0) continue;
            int y = yellow / x;
            if ((x + 2) * (y + 2) == brown + yellow) {
                answer[0] = Math.max(x, y) + 2;
                answer[1] = Math.min(x, y) + 2;
            }
        }
        
        return answer;
    }
}