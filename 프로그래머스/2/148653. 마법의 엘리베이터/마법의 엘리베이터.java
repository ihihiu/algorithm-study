class Solution {
    public int solution(int storey) {
        int answer = 0;
        int x = storey;
        while (x > 0) {
            int leftover = x % 10;
            x/= 10;
            if (leftover == 5) {
                answer += (10 - leftover);
                if (x % 10 >= 5) {    
                    x++;
                }
                
            } else if (leftover > 5) {
                answer += (10 - leftover);
                x++;
            } else {
                answer += leftover;
            }
            
        }
        return answer;
    }
}