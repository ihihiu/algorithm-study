import math
def solution(progresses, speeds):
    answer = []
    days = []
    for i in range(len(progresses)):
        days.append(math.ceil((100 - progresses[i])/speeds[i]))
    
    cnt = 1
    pre = days[0]
    for i in range(1, len(days)):
        if days[i] <= pre:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            pre = days[i]
    answer.append(cnt)

        
    return answer