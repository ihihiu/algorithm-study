def solution(arr):
    answer = []
    now = arr[0]
    answer.append(now)
    for a in arr:
         if a != now:
                answer.append(a)
                now = a
    return answer