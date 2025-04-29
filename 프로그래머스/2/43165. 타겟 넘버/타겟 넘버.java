import java.util.*;
class Solution {
    static int answer;
    
    public void dfs(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        else {
            dfs(depth + 1, sum + numbers[depth], numbers, target);
            dfs(depth + 1, sum - numbers[depth], numbers, target);
        }
    }
    
    public int solution(int[] numbers, int target) {
        //answer = 0;
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
}