import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (a, b) -> (b + a).compareTo((a + b)));
        StringBuilder sb = new StringBuilder();
        for (String x : str) sb.append(x);
        if (sb.charAt(0) == '0') return "0";
        String answer = sb.toString();
        return answer;
        
    }
}