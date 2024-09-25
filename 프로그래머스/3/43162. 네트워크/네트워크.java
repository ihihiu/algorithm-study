class Solution {
    int[] ch;
    public void DFS(int n, int[][] computers, int m) {
        ch[m] = 1;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0 && computers[m][i] == 1) {
                DFS(n, computers, i);
            }
        }
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                DFS(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
}