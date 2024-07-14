def solution(participant, completion):
    answer = ''
    dict = {}
    for p in participant:
        if p in dict.keys():
            dict[p] += 1
        else:
            dict[p] = 1
    for c in completion:
        dict[c] -= 1
    
    for key, value in dict.items():
        if value == 1:
            answer += key
            break
    
    return answer