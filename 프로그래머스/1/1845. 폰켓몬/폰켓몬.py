def solution(nums):
    answer = 0
    result = []
    for a in nums:
        if a not in result:
            result.append(a)
            answer += 1
            if answer == len(nums) // 2:
                break
    
    return answer