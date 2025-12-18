import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = now[0] + dx[j];
                    int y = now[1] + dy[j];
                    if (x < 0 || x >= N || y < 0 || y >= M || maps[x][y] != 1) continue;
                    maps[x][y] = maps[now[0]][now[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        
        
        return maps[N - 1][M - 1] == 1 ? -1 : maps[N - 1][M - 1];
    }
}