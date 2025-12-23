import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        
        for (char d: dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            if (d == 'U') ny++;
            else if (d == 'D') ny--;
            else if (d == 'L') nx--;
            else nx++;
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
        
            String path = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            if (!visited.contains(path)) {
                visited.add(path);
                visited.add(path2);
                answer++;
            }
            x = nx;
            y = ny;

        }
        
        
        return answer;
    }
}