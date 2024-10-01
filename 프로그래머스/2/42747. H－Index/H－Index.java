import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            if (arr[i] >= i + 1) answer = i + 1;
            else break;
        }
        
        return answer;
    }
}