import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            int hIdx = n - i;
            if (citations[i] >= n - i) {
                answer = hIdx;
                break;
            }
        }
        return answer;
    }
}