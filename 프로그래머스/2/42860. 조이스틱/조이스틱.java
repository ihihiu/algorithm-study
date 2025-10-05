import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int N = name.length();
  
        // 1. 알파벳 변경 횟수
        for (int i = 0; i < N; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 2. 좌우 이동 최솟값
        int min = N - 1; // 왼쪽에서부터 순차 탐색했을 때
        for (int i = 0; i < N; i++) {
            int next = i + 1;
            
            // 연속된 A 건너뛰기
            while (next < N && name.charAt(next) == 'A') {
                next++;
            }
            
            // 왼쪽으로 되돌아가는 경우
            int move = i + N - next + Math.min(i, N - next);
            min = Math.min(min, move);
        }
        
        answer += min;
        
        return answer;
    }
}