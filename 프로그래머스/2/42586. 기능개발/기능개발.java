import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = progresses.length;
        int day = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int now = progresses[i] + day * speeds[i];
            if (now >= 100) {
                ans++;
            }
            else {
                if (ans != 0) res.add(ans);
                ans = 1;
                int remain = (100 - now) / speeds[i];
                if ((100 - now) % speeds[i] != 0) remain++;
                day += remain;
            }
        }
        if (ans != 0) res.add(ans);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}