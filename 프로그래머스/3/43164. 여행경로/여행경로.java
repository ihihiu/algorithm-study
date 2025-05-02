import java.util.*;
class Solution {
    static String[] answer;
    static String[] res;
    static boolean[] ch;
    static boolean find;
    
    static public void dfs(int depth, String[][] tickets, String now) {
        if (find) return;
        if (depth == tickets.length) {
            res = answer.clone();
            find = true;
            return;
        }
        else {
            for (int i = 0; i < tickets.length; i++) {
                if (!ch[i] && tickets[i][0].equals(now)) {
                    ch[i] = true;
                    answer[depth + 1] = tickets[i][1];
                    dfs(depth + 1, tickets, tickets[i][1]);
                    ch[i] = false;
                }
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        ch = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        
        
        
        dfs(0, tickets, "ICN");
        
        return res;
    }
}