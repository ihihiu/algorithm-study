def solution(phone_book):
    answer = True
    hash_map = {}
    for nums in phone_book:
        hash_map[nums] = 1

    
    for nums in phone_book:
        front = ""
        for num in nums:
            front += num
            if front in hash_map and front != nums:
                answer = False
                break
    return answer