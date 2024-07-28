def solution(number):
    answer = 0
    size = len(number)
    for i in range(size):
        for j in range(i + 1, size):
            for k in range(j + 1, size):
                if number[i] + number[j] + number[k] == 0:
                    answer += 1
    return answer