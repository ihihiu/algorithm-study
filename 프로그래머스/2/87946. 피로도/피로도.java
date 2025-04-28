import java.util.*;
class Solution {
    static int answer;
    static int[] ch;
    
    static public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (ch[i] == 0 && k >= dungeons[i][0]) {
                ch[i] = 1;
                answer = Math.max(answer, depth + 1);
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                ch[i] = 0;
            }
        }

    }
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        ch = new int[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
}