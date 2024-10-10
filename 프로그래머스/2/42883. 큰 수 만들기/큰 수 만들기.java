class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder res = new StringBuilder();
        int len = number.length();
        int idx = 0;
        for (int i = 0; i < len - k; i++){
            int max = -1;
            for (int j = idx; j <= k + i; j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                    if (max == 9) break;
                }
            }
            res.append(max);
        }
        
        answer = res.toString();
        return answer;
    }
}