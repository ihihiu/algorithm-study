import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] str = s.split("-");
        Arrays.sort(str, (a, b) -> a.length() - b.length());
        for(String x : str) {
            String[] tmp = x.split(",");
            for (String y : tmp) {
                int num = Integer.parseInt(y);
                if (!answer.contains(num)) {
                    answer.add(num);
                    break;
                }
            }
        }
        
        return answer;
    }
}