import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] ch = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                answer++;
                ch[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (computers[now][j] == 1 && !ch[j]) {
                            ch[j] = true;
                            queue.offer(j);
                            
                        }
                    }
                }
                
            }
        }
        
        
        return answer;
    }
}