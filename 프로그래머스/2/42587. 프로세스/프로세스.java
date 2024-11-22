import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }
        Integer[] p = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(p, Collections.reverseOrder());
        int answer = 0;
        while (true) {
            int[] now = queue.poll();
            if (now[0] == p[answer]) {
                answer++;
                if (now[1] == location) break;
            }
            else queue.offer(now);
        }
        return answer;
    }
}