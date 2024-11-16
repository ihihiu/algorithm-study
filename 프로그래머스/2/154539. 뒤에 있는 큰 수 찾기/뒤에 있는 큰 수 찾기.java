class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        answer[n - 1] = -1;
        
        for (int i = n - 2; i >= 0; i--) {
            if (numbers[i] < numbers[i + 1]) {
                answer[i] = numbers[i + 1];
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (answer[j] == -1) {
                    answer[i] = -1;
                    break;
                }
                else if (numbers[i] < answer[j]) {
                    answer[i] = answer[j];
                    break;
                }
            }
            
        }
        
        
        return answer;
    }
}