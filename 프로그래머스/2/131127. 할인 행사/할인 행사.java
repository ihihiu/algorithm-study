import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> sh = new HashMap<>();
        for (int i = 0; i < 9; i++) sh.put(discount[i], sh.getOrDefault(discount[i], 0) + 1);
        int lt = 0;
        for (int rt = 9; rt < discount.length; rt++) {
            sh.put(discount[rt], sh.getOrDefault(discount[rt], 0) + 1);
            boolean flag = true;
            for (int i = 0; i < want.length; i++) {
                if (!sh.containsKey(want[i]) || sh.get(want[i]) < number[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
            sh.put(discount[lt], sh.get(discount[lt]) - 1);
            lt++;
        }
        
        return answer;
    }
}