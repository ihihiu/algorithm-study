import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.valueOf(x.split(":")[0]) * 60;
        int m = Integer.valueOf(x.split(":")[1]);
        return h + m;
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        LinkedList<int[]> list = new LinkedList<>();
        for (String[] x : book_time) {
            list.add(new int[]{getTime(x[0]), getTime(x[1])});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        int size = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> a - b);
        
        for (int[] now : list) {
            while (!pQ.isEmpty() && pQ.peek() <= now[0]) {
                pQ.poll();
                size--;
            }
            pQ.offer(now[1] + 10);
            size++;
            if (size > answer) answer = size;
        }
        
        return answer;
    }
}