import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }
        Integer[] p = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(p, (a, b) -> b - a);
        int idx = 0;
        while (true) {
            int[] now = queue.poll();
            if (now[0] != p[idx]) queue.offer(now);
            else {
                answer++;
                if (now[1] == location) break;;
                idx++;
            }
        }
        
        return answer;
    }
}