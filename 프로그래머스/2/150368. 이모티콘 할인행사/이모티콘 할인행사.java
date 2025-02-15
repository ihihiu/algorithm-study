import java.util.*;
class Solution {
    static int joiner = 0;
    static int price = 0;
    static int[] percent = {10, 20, 30, 40};
    static int[] tmp;
    
    public void dfs(int depth, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            int cnt = 0, sum = 0;
            
            for (int[] user : users) {
                int cost = 0;
                boolean flag = false;
                for (int i = 0; i < emoticons.length; i++) {
                    if (tmp[i] >= user[0]) {
                        cost += emoticons[i] * (100 - tmp[i]) / 100;
                        if (cost >= user[1]) {
                            flag = true;
                            cnt++;
                            break;
                        }
                    }
                }
                if (!flag) sum += cost;
            }
            if (cnt > joiner) {
                joiner = cnt;
                price = sum;
            }
            else if (joiner == cnt && sum > price) price = sum;
            return;
        }
        else {
            for (int i = 0; i < 4; i++) {
                tmp[depth] = percent[i];
                dfs(depth + 1, users, emoticons);
            }
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        tmp = new int[emoticons.length];
        dfs(0, users, emoticons);
        return new int[]{joiner, price};
    }
}