import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.parseInt(x.split(":")[0]);
        int m = Integer.parseInt(x.split(":")[1]);
        return h * 60 + m;
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        LinkedList<int[]> timeList = new LinkedList<>();
        for (String[] x : book_time) {
            timeList.offer(new int[]{getTime(x[0]), getTime(x[1])});
        }
        Collections.sort(timeList, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> a - b);
        while (!timeList.isEmpty()) {
            int[] now = timeList.poll();
            while (!pQ.isEmpty() && pQ.peek() <= now[0]){
                pQ.poll();
            }
            pQ.offer(now[1] + 10);
            answer = Math.max(answer, pQ.size());
        }
        
        return answer;
    }
}