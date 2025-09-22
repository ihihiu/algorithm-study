import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }
        
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        
        while (!queue.isEmpty()) {
            if (queue.peek()[0] == priorities[idx]) {
                idx--;
                answer++;
                if (queue.peek()[1] == location) {
                    break;
                }
                else {
                    queue.poll();
                }
            }
            else {
                queue.offer(queue.poll());
            }
        }
        
        
        return answer;
    }
}