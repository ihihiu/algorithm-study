import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] relation = new boolean[n + 1][n + 1];
        
        for (int[] result : results) {
            relation[result[0]][result[1]] = true;
        }
        
        //플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                 for (int j = 1; j <= n; j++) {
                     if (relation[i][k] && relation[k][j]) relation[i][j] = true;
                 }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (relation[i][j] || relation[j][i]) cnt++;
            }
            if (cnt == n - 1) answer++;
        }
        
        return answer;
    }
}