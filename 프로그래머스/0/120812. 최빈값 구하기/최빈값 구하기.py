def solution(array):
    answer = 0
    hash_map = {}
    for a in array:
        hash_map[a] = hash_map.get(a, 0) + 1
        
    max_value = max(hash_map.values())
    cnt = 0
    for key, value in hash_map.items():
        if value == max_value:
            cnt += 1
            answer = key
    if cnt != 1:
        answer = -1
        
    return answer