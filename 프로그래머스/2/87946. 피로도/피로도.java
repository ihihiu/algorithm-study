import java.util.*;
class Solution {
    int answer;
    int n;
    int[] ch;
    
    public void DFS(int depth, int k, int[][] dungeons) {
        if (depth > answer) answer = depth;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0 && k >= dungeons[i][0]) {
                    ch[i] = 1;
                    DFS(depth + 1, k - dungeons[i][1], dungeons);
                    ch[i] = 0;
            }
        }
        
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        n = dungeons.length;
        ch = new int[n];
        DFS(0, k, dungeons);
        return answer;
    }
}