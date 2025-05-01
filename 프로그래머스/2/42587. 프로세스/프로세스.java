import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<int[]> list = new LinkedList<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < priorities.length; i++) {
            pQ.offer(priorities[i]);
            list.add(new int[]{priorities[i], i});
        }
        
        while (true) {
            while (pQ.peek() != list.peek()[0]) {
                list.offer(list.poll());
            }
            pQ.poll();
            answer++;
            if (list.poll()[1] == location) break;
        }
        
        
        return answer;
    }
}