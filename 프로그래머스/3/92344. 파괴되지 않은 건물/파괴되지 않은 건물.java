class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] graph = new int[n + 1][m + 1];
        int answer = 0;

        
        for (int[] sk : skill) {
            int degree = sk[0] == 1 ? -sk[5] : sk[5];
            graph[sk[1]][sk[2]] += degree;
            graph[sk[1]][sk[4] + 1] -= degree;
            graph[sk[3] + 1][sk[2]] -= degree;
            graph[sk[3] + 1][sk[4] + 1] += degree;
            
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                graph[i][j] += graph[i][j - 1];
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                graph[i][j] += graph[i - 1][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 if (board[i][j] + graph[i][j] > 0) answer++;
             }
        }
        
        return answer;
    }
}