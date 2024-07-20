def solution(name, yearning, photo):
    answer = []
    hash_map = dict()
    for i in range(len(name)):
        hash_map[name[i]] = yearning[i]
    for i in photo:
        sum = 0
        for j in range(len(i)):
            if i[j] in hash_map.keys():
                sum += hash_map[i[j]]
        answer.append(sum)
    
    return answer