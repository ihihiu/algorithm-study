def solution(rank, attendance):
    answer = 0
    indexs = []
    for i in range(len(rank)):
        indexs.append((rank[i], i))
        
    indexs.sort()
    
    result = []
    for i in indexs:
        if attendance[i[1]]:
            result.append(i[1])
            if len(result) == 3:
                break
    
    answer = 10000 * result[0] + 100 * result[1] + result[2]
    
    return answer