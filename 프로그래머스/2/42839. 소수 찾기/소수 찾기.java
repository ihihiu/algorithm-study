import java.util.*;
class Solution {
    static int n, answer;
    static HashSet<Integer> set;
    static int[] ch;
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public void dfs(int depth, String tmp, String numbers) {
        if (depth != 0) {
            int n = Integer.parseInt(tmp);
            if (!set.contains(n)) {
                set.add(n);
                if (isPrime(n)) answer++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                dfs(depth + 1, tmp + numbers.charAt(i), numbers);
                ch[i] = 0;
            }
        }
    }
    public int solution(String numbers) {
        answer = 0;
        n = numbers.length();
        set = new HashSet<>();
        ch = new int[n];
        dfs(0, "", numbers);
        return answer;
    }
}