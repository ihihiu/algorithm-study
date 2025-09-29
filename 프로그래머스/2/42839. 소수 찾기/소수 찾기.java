import java.util.*;
class Solution {
    static Set<Integer> set;
    static int N;
    static boolean[] ch;
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        N = numbers.length();
        ch = new boolean[N];
        dfs(0, "", numbers);
        
        for (int x : set) {
            if (x <= 1) continue;
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) answer++;
        }
        
        return answer;
    }
    
    public void dfs(int depth, String tmp, String numbers) {
        if (depth == N) {
            return;
        }
        for (int i = 0; i < N; i++) {
            if (ch[i] == false) {
                tmp += (numbers.charAt(i) - '0');
                set.add(Integer.parseInt(tmp));
                ch[i] = true;
                dfs(depth + 1, tmp, numbers);
                ch[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }
}