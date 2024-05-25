def solution(s):
    answer = ''
    hash_map = {}
    for i in s:
        if i in hash_map:
            hash_map[i] += 1
        else:
            hash_map[i] = 1
    for i in hash_map.keys():
        if hash_map[i] == 1:
            answer += i
        
    answer = ''.join(sorted(list(answer)))
    return answer