import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.valueOf(x.split(":")[0]);
        int m = Integer.valueOf(x.split(":")[1]);
        return h * 60 + m;
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        int n = book_time.length;
        
        LinkedList<int[]> queue = new LinkedList<>();
        for (String[] x : book_time) {
            queue.offer(new int[]{getTime(x[0]), getTime(x[1])});
        }
        Collections.sort(queue, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int[] now = queue.poll();
            while (!pQ.isEmpty() && pQ.peek() <= now[0]) {
                pQ.poll();
            }
            pQ.offer(now[1] + 10);
            answer = Math.max(answer, pQ.size());
        }
        
        return answer;
    }
}