def solution(brown, yellow):
    answer = []
    nums = []
    for i in range(1, yellow + 1):
        if yellow % i == 0:
            nums.append(i)
            
    if len(nums) % 2 == 1:
        nums.insert(len(nums)//2, nums[len(nums)//2])
    
    for i in range(0, len(nums)//2):
        x = nums[i] + 2
        y = nums[len(nums) - 1 - i] + 2
        if 2 * x + 2 * y - 4 == brown:
            answer.append(y)
            answer.append(x)
            break
    

    
    
    return answer