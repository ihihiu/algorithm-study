import java.util.*;
class Solution {
    static ArrayList<String> answer;
    static int[] ch;
    static int n;
    static boolean find = false;
    
    public void dfs(int depth, String now, ArrayList<String> tmp, String[][] tickets) {
        if (find) return;
        if (depth == n) {
            for (int i = 0; i < tmp.size(); i++) answer.add(tmp.get(i));
            find = true;
        }
        else {
            for (int i = 0; i < n; i++) {
                if (tickets[i][0].equals(now) && ch[i] == 0) {
                    ch[i] = 1;
                    tmp.add(tickets[i][1]);
                    dfs(depth + 1, tickets[i][1], tmp, tickets);
                    tmp.remove(tmp.size() - 1);
                    ch[i] = 0;
                }
            }
        }
        
    }
    
    public ArrayList<String> solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        n = tickets.length;
        ch = new int[n];
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("ICN");
        answer = new ArrayList<>();
        dfs(0, "ICN", tmp, tickets);
        return answer;
    }
}