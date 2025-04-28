import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> sh = new HashMap<>();
        //HashMap<String, Integer> now = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            sh.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 9; i++) {
            if (sh.containsKey(discount[i])) sh.put(discount[i], sh.get(discount[i]) - 1);
        }
        
        int lt = 0;
        for (int i = 9; i < discount.length; i++) {
            if (sh.containsKey(discount[i])) sh.put(discount[i], sh.get(discount[i]) - 1);
            
            boolean flag = true;
            for (int value : sh.values()) {
                if (value > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
            if (sh.containsKey(discount[lt])) sh.put(discount[lt], sh.get(discount[lt]) + 1);
            lt++;
        }
        
        
        return answer;
    }
}