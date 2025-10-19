import java.util.*;
class Solution {
    static boolean flag = false;
    static String[] answer;
    static boolean[] ch;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        ch = new boolean[tickets.length];
        dfs(0, "ICN", tickets);
        return answer;
    }
    
    static public void dfs(int depth, String start, String[][] tickets) {
        if (flag) return;
        if (depth == tickets.length) {
            flag = true;
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!ch[i] && tickets[i][0].equals(start)) {
                answer[depth + 1] = tickets[i][1];
                ch[i] = true;
                dfs(depth + 1, tickets[i][1], tickets);
                if (flag) return;
                ch[i] = false;
            }
        }
    }
}