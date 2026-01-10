import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        // k진수로 만들기
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        
        // 숫자 분리
        String[] str = sb.toString().split("0");
        
        // 소수 판별
        for (String s : str) {
            if (s.isEmpty()) continue;
            
            long num = Long.parseLong(s);
            if (num <= 1) continue;
            
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        
        return answer;
    }
}