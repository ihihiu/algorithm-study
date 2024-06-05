from collections import deque
def solution(people, limit):
    answer = 0
    people.sort()
    queue = deque(people)
    while queue:
        now = queue.pop()
        answer += 1
        if len(queue) == 0:
            break
        if now + queue[0] <= limit:
            queue.remove(queue[0])
    
    return answer