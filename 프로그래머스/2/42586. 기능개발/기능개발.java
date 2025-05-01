import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        int n = progresses.length;
        
        int cnt = 0;
        int pre = -1;
        for (int i = 0; i < n; i++) {
            int leftover = 100 - progresses[i];
            int days = leftover / speeds[i];
            if (leftover % speeds[i] != 0) days++;
            if (days <= pre) {
                cnt++;
            }
            else {
                arr.add(cnt);
                cnt = 1;
                pre = days;
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