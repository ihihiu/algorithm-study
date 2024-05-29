from itertools import permutations
def solution(numbers):
    result = []
    answer = 0
    nums = [i for i in numbers]
    per = []
    for i in range(1, len(numbers) + 1):
        per += list(permutations(nums, i))
    arr = [int(''.join(p)) for p in per]
    
    for a in arr:
        if a < 2:
            continue
        check = True
        for i in range(2, int(a ** 0.5) + 1):
            if a % i ==0:
                check = False
                break
        if check:
            result.append(a)
            
    return len(set(result))
