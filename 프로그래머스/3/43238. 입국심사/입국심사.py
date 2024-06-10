def solution(n, times):
    start = min(times)
    end = n * max(times)
    
    answer = end
    
    while start <= end:
        mid = (start + end) // 2
        result = 0
        for time in times:
            result += mid // time
        if result >= n:
            answer = min(answer, mid)
            end = mid - 1
        else:
            start = mid + 1
    
    return answer