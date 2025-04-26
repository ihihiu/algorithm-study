import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        int[] ch = new int[n];
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            int idx = i;
            int cnt = 0;
            while (ch[idx] == 0) {
                ch[idx] = 1;
                cnt++;
                idx = cards[idx] - 1;
            }
            arr.add(cnt);
        }
        Collections.sort(arr, (a, b) -> b - a);
        if (arr.size() <= 1) return 0;
        return arr.get(0) * arr.get(1);
    }
}