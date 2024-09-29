import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> sh = new HashMap<>();
        for (String[] x : clothes) {
            sh.put(x[1], sh.getOrDefault(x[1], 0) + 1);
        }
        for (int x : sh.values()) {
            answer *= (x + 1);
        }
        answer--;
        return answer;
    }
}