import java.util.*;
class Solution {
    static int[][] dp;
    
    public int dfs(int[][] triangle, int depth, int idx) {
        if (depth == triangle.length - 1) return triangle[depth][idx];
        if (dp[depth][idx] != -1) return dp[depth][idx];
        int left = dfs(triangle, depth + 1, idx);
        int right = dfs(triangle, depth + 1, idx + 1);
        return dp[depth][idx] = triangle[depth][idx] + Math.max(left, right);
    }
  
    
    public int solution(int[][] triangle) {
        int n = triangle.length;
        dp = new int[n][n];
        for (int[] x : dp) Arrays.fill(x, -1);
        int answer = dfs(triangle, 0, 0);
        return answer;
    }
}