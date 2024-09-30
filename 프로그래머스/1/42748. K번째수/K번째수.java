import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int k = 0;
        for (int[] x : commands) {
            int[] tmp = new int[x[1] - x[0] + 1];
            int idx = 0;
            for (int i = x[0] - 1 ; i < x[1]; i++) {
                tmp[idx++] = array[i];
            }
            Arrays.sort(tmp);
            answer[k++] = tmp[x[2] - 1];    
        }
        
        return answer;
    }
}