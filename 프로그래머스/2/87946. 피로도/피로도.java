import java.util.*;
class Solution {
    static boolean[] ch;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        ch = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    public static void dfs(int depth, int k, int[][] dungeons) {
        if (depth == dungeons.length || answer == dungeons.length) return;
        for (int i = 0; i < dungeons.length; i++) {
            if (!ch[i] && dungeons[i][0] <= k) {
                ch[i] = true;
                answer = Math.max(answer, depth + 1);
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                ch[i] = false;
            }
        }
    }
}