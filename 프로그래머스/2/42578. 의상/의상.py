def solution(clothes):
    answer = 0
    hash_map = {}
    for name, category in clothes:
        if category in hash_map.keys():
            hash_map[category] += [name]
        else:
            hash_map[category] = [name]
    
    
    answer = 1
    for i, value in hash_map.items():
        answer *= (len(value) + 1)
    
    return answer - 1