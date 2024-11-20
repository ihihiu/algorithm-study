import java.util.*;
class Solution {
    static int answer, n;
    
    public void dfs(int depth, int res, int[] picks, String[] minerals) {
        if (res > answer) return;
        else if (depth >= n || Arrays.stream(picks).sum() == 0) answer = res;
        else {
            for (int i = 0; i < 3; i++) {
                if (picks[i] > 0) {
                    picks[i]--;
                    int sum = 0;
                    for (int j = depth; j < Math.min(n, depth + 5); j++) {
                        if (i == 0) sum += 1;
                        else if (i == 1) {
                            if (minerals[j].equals("diamond")) sum += 5;
                            else sum += 1;
                        }
                        else{
                            if (minerals[j].equals("diamond")) sum += 25;                        
                            else if (minerals[j].equals("iron")) sum += 5;
                            else sum += 1;
                        }
                    }
                    dfs(depth + 5, res + sum, picks, minerals);
                    picks[i]++;
                }
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        n = minerals.length;
        dfs(0, 0, picks, minerals);
        return answer;
    }
}