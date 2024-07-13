def solution(quiz):
    ans = []
    for q in quiz:
        arr = q.split()
        if arr[1] == "+":
            if int(arr[0]) + int(arr[2]) == int(arr[4]):
                ans.append("O")
            else:
                ans.append("X")
        if arr[1] == "-":
            if int(arr[0]) - int(arr[2]) == int(arr[4]):
                ans.append("O")
            else:
                ans.append("X")
    return ans