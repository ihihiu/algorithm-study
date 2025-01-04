import java.util.*;
class Solution {
    static int n;
    static int answer;
    static public void dfs(int depth, int[] numbers, int res, int target) {
        if (depth == n) {
            if (res == target) answer++;
            return;
        }
        else {
            dfs(depth + 1, numbers, res + numbers[depth], target);
            dfs(depth + 1, numbers, res - numbers[depth], target);
        }
        
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        dfs(0, numbers, 0, target);
        return answer;
    }
}