import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 스코빌 지수 낮은 순
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pQ.offer(scoville[i]);
        }
        
        while (true) {
            // 스코빌 지수 K 이상인지 확인
            if (pQ.peek() >= K) {
                return answer;
            }

            // 남은 원소가 1개뿐이면 종료
            if (pQ.size() == 1) return -1;

            // 두 원소 꺼내기
            int first = pQ.poll();
            int second = pQ.poll();

            // 새로운 스코빌 지수 만들기
            int newScoville = first + second * 2;
            pQ.add(newScoville);
            
            answer++;
        }
        
    
    }
}