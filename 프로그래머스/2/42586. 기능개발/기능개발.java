import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int N = progresses.length;
        
        int day = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int x = 100 - progresses[i];
            int y = x / speeds[i];
            if (x % speeds[i] != 0) y++;
            if (day < y) {
                arr.add(cnt);
                cnt = 1;
                day =y;
            } else {
                cnt++;
            }
        }
        arr.add(cnt);
        int[] answer = new int[arr.size() - 1];
        
        for (int i = 1; i < arr.size(); i++) {
            answer[i - 1] = arr.get(i);
        }
        
        return answer;
    }
}