import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        int N = numbers.length;
        
        ArrayList<String> arr = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            arr.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        for (int i = 0; i < N; i++) {
            answer += arr.get(i);
        }
        
        if (answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}