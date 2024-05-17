def solution(myString):
    answer = []
    result = myString.split('x')
    for r in result:
        answer.append(len(r))
    return answer