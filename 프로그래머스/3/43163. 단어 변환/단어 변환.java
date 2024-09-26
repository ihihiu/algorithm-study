class Solution {
    int answer;
    int n;
    int[] ch;
    
    public int diff(String a, String b) {
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) res++;
        }
        return res;
    }
    
    public void DFS(int depth, String pre, String target, String[] words) {
        if (depth > answer) return;
        if (depth > n + 1) return;
        if (pre.equals(target)){
            answer = Math.min(answer, depth);
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0 && diff(pre, words[i]) <= 1) {
                    ch[i] = 1;
                    DFS(depth +1, words[i], target, words);
                    ch[i] = 0;
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        n = words.length;
        ch = new int[n];
        boolean flag = false;
        for (String x : words) {
            if (x.equals(target)) {
                flag = true;
                break;
            }
        }
        if (!flag) return 0;
        
        DFS(0, begin, target, words);
        return answer;
    }
}