import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int max = 0;
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int p = progresses[i];
            int s = speeds[i];
            int day = 0;
            while (p < 100) {
                day++;
                p += s;
            }
            if (day > max) {
                arr.add(cnt);
                max = day;
                cnt = 1;
            }
            else {
                cnt++;
            }
        }
        arr.add(cnt);
        int[] answer = new int[arr.size() -  1];
        for (int i = 1; i < arr.size(); i++) answer[i - 1] = arr.get(i);
        return answer;
    }
}