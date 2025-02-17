import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        HashMap<String, Integer> sh = new HashMap<>();
        for (int i = 0; i < n; i++) sh.put(want[i], number[i]);
        
        for (int i = 0; i < 9; i++) {
            if (!sh.containsKey(discount[i])) continue;
            sh.put(discount[i], sh.get(discount[i]) - 1);
        }
        
        int lt = 0; 
        for (int rt = 9; rt < discount.length; rt++) {
            if (sh.containsKey(discount[rt])) sh.put(discount[rt], sh.get(discount[rt]) - 1);
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