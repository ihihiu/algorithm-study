import java.util.*;
class Solution {
    static int N;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        dfs(0, numbers, target, 0);
        return answer;
    }
    
    static public void dfs(int depth, int[] numbers, int target, int now) {
        if (depth == N) {
            if (now == target) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, numbers, target, now + numbers[depth]);
        dfs(depth + 1, numbers, target, now - numbers[depth]);
    }
}