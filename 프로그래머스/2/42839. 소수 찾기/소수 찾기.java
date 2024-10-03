import java.util.*;
class Solution {
    int n;
    int[] ch;
    Set<Integer> set;
    
    public void findPrime(String tmp) {
        int num = Integer.parseInt(tmp);
        if (num == 0 || num == 1) return;
        if (set.contains(num)) return;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return;
        }
        set.add(num);
    }
    
    public void DFS(int depth, String numbers, String tmp) {
        if (depth == n) return;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                String str = tmp + numbers.charAt(i);
                findPrime(str);
                DFS(depth + 1, numbers, str);
                ch[i] = 0;
            }
        }
    }
    
    public int solution(String numbers) {
        set = new HashSet<>();
        n = numbers.length();
        ch = new int[n];
        DFS(0, numbers, "");
        int answer = set.size();
        return answer;
    }
}