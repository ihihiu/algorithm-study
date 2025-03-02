import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int cnt = 0, maxDay = 0;
        for (int i = 0; i < progresses.length; i++) {
            int x = 100 - progresses[i];
            int days = x / speeds[i];
            if (x % speeds[i] != 0) days += 1;
            if (days <= maxDay) {
                cnt++;
            }
            else {
                if (cnt != 0) res.add(cnt);
                cnt = 1;
                maxDay = days;
            }
        }
        res.add(cnt);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }
}