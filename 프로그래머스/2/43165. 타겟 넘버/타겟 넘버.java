import java.util.*;
class Solution {
    static int answer;
    public void dfs(int depth, int[] numbers, int target, int tmp) {
        if (depth == numbers.length) {
            if (target == tmp) answer++;
            return;
        } 
        else {
            dfs(depth + 1, numbers, target, tmp + numbers[depth]);
            dfs(depth + 1, numbers, target, tmp - numbers[depth]);
        }
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, numbers, target, 0);
        return answer;
    }
}