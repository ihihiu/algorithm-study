import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] graph = new char[m][n];
        for (int i = 0; i < m; i++) {
            graph[i] = board[i].toCharArray();
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int[] ch = new int[n];
        
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};
        
        while (true) {
            HashMap<Integer, HashSet<Integer>> sh = new HashMap<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    boolean flag = true;
                    ArrayList<int[]> arr = new ArrayList<>();
                    arr.add(new int[]{i, j});
                    if (graph[i][j] != 'x') {
                        for (int k = 0; k < 3; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (graph[nx][ny] != graph[i][j] || graph[nx][ny] == 'x') {
                                flag = false;
                                break;
                            }
                            arr.add(new int[]{nx, ny});
                        }
                        if (flag) {
                            for (int[] xy : arr) {
                                sh.putIfAbsent(xy[1], new HashSet<>());
                                sh.get(xy[1]).add(xy[0]);
                            }
                        }
                    } 
                }
            }
            if (sh.isEmpty()) break;
            for (int j : sh.keySet()) {
                HashSet<Integer> set = sh.get(j);
                answer += set.size();
                ArrayList<Character> arr = new ArrayList<>();
                for (int i = m - 1; i >= 0; i--) {
                    if (graph[i][j] == 'x') break;
                    if (set.contains(i)) continue;
                    arr.add(graph[i][j]);
                }
                
                for (int i = 0; i < arr.size(); i++) {
                    graph[m - 1 - i][j] = arr.get(i);
                }
                for (int i = 0; i < set.size(); i++) {
                    graph[m - 1 - arr.size() - i][j] = 'x';
                }
                
            }
            
        }
        
        return answer;
    }
}