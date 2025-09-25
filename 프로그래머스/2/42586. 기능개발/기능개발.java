import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        int cnt = 0;
        int day = 0;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int x = 100 - progresses[i];
            int d = x / speeds[i] + (x % speeds[i] == 0 ? 0 : 1);
            if (d > day) {
                day = d;
                arr.add(cnt);
                cnt = 1;
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