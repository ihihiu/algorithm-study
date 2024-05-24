import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    length = len(scoville)
    while scoville:
        fisrt = heapq.heappop(scoville)
        if fisrt >= K:
            return answer
        if answer == length - 1:
            return -1
        second = heapq.heappop(scoville)
        heapq.heappush(scoville, fisrt + 2 * second)
        answer += 1

    return answer