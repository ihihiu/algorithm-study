import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = priorities.length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        Arrays.sort(priorities);
        int ord = n - 1;
        
        while (true) {
            if (queue.peek()[1] == priorities[ord]) {
                answer++;    
                if (queue.peek()[0] == location) {
                    break;
                }
                queue.poll();
                ord--;
            } else {
                queue.add(queue.poll());
            }
            
        }
        
        return answer;
    }
}