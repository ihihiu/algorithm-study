def dfs(numbers, target, total, depth):
    if depth == len(numbers):
        if total == target:
            return 1
        else:
            return 0
    else:
        answer = 0
        answer += dfs(numbers, target, total + numbers[depth], depth + 1)
        answer += dfs(numbers, target, total - numbers[depth], depth + 1)
        return answer
        
            
def solution(numbers, target):
    answer = dfs(numbers, target, 0, 0)
    return answer