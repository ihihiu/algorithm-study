import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        int lt = routes[0][0];
        int rt = routes[0][1];
        answer++;
        
        for (int i = 1; i < routes.length; i++) {
            int l = routes[i][0];
            int r = routes[i][1];
            if ((lt <= l && l <= rt) || (lt <= r && r <= rt)) {
                lt = Math.max(lt, l);
                rt = Math.min(rt, r);
            } else {
                answer++;
                lt = l;
                rt = r;
            }
        }
        
        return answer;
    }
}