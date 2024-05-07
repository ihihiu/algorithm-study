import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    n = len(scoville)
    for i in range(n):
        first = heapq.heappop(scoville)
        if first >= K:
            break
        if i == n - 1:
            return -1
        second = heapq.heappop(scoville)
        heapq.heappush(scoville, first + second * 2)
        answer += 1
    
    return answer
