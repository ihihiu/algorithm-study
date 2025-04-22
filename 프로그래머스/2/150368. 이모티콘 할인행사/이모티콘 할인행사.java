import java.util.*;
class Solution {
    static ArrayList<int[]> arr;
    static int[] salePercent = {10, 20, 30, 40};
    
    static void dfs(int depth, int[] price, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            int cnt = 0, sum = 0;
            for (int i = 0; i < price.length; i++) {
                if (price[i] >= users[i][1]) cnt++;
                else sum += price[i];
            }
            arr.add(new int[]{cnt, sum});
            return;
        }
        else {
           for (int percent : salePercent) {
               int[] tmp = Arrays.copyOf(price, price.length);
               for (int i = 0; i < tmp.length; i++) {
                   if (users[i][0] <= percent) {
                       tmp[i] += emoticons[depth] * (100 - percent) / 100;
                   }
               }
               dfs(depth + 1, tmp, users, emoticons);
               
           }
                 
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] price = new int[users.length];
        arr = new ArrayList<>();
        dfs(0, price, users, emoticons);
        Collections.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        answer[0] = arr.get(0)[0];
        answer[1] = arr.get(0)[1];
        return answer;
    }
}