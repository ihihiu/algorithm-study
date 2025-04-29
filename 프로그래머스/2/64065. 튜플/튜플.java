import java.util.*;
class Solution {
    public int[] solution(String s) {
        int n = s.length();
        
        HashMap<Integer, Integer> sh = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(s.charAt(i))) continue;
            else {
                String num = "";
                while (Character.isDigit(s.charAt(i))) {
                    num += s.charAt(i);
                    i++;
                }
                int number = Integer.valueOf(num);
                sh.put(number, sh.getOrDefault(number, 0) + 1);
            }
        }
        
        ArrayList<int[]> res = new ArrayList<>();
        for (int num : sh.keySet()) {
            res.add(new int[]{num, sh.get(num)});
        }
        
        Collections.sort(res, (a, b) -> b[1] - a[1]);
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i)[0];
        }
        return answer;
    }
}