import java.util.*;
class Solution {
    static int answer;
    static int n, end;
    
    public void dfs(int depth, int[] picks, String[] minerals, int sum) {
        if (sum > answer) return;
        if (depth == end) {
            answer = Math.min(answer, sum);
            return;
        }
        else {
            for (int i = 0; i < 3; i++) {
                if (picks[i] == 0) continue;
                picks[i]--;
                int tmp = 0;
                for (int j = depth * 5; j < Math.min(depth * 5 + 5, n); j++) {
                    if (i == 0) {
                        tmp++;
                    }
                    else if (i == 1) {
                        if (minerals[j].equals("diamond")) tmp += 5;
                        else tmp++;
                    }
                    else {
                        if (minerals[j].equals("diamond")) tmp += 25;
                        else if (minerals[j].equals("iron")) tmp += 5;
                        else tmp++;
                    }                
                }
                dfs(depth + 1, picks, minerals, sum + tmp);
                picks[i]++;    
            }
        }
        
    }
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        n = minerals.length;
        end = n % 5 == 0 ? n / 5 : n / 5 + 1;
        int p = 0;
        for (int x : picks) p += x;
        end = Math.min(end, p);
        dfs(0, picks, minerals, 0);
        return answer;
    }
}