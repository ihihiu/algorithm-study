def solution(k, m, score):
    answer = 0
    score.sort(reverse = True)
    n = len(score) // m
    if n == 0:
        answer = 0
    else:
        start = m - 1
        for i in range(0, n):
            answer += m * score[start]
            start += m
    return answer