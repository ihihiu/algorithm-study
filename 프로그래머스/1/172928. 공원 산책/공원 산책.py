def solution(park, routes):
    answer = []
    n = len(park)
    m = len(park[0])
    for i in range(n):
        for j in range(m):
            if park[i][j] == 'S':
                x = i
                y = j
                break
    
    for route in routes:
        direction, num = route.split()
        if direction == 'N':
            flag = True
            for i in range(1, int(num) + 1):
                if x - i < 0:
                    flag = False
                    break
                elif park[x - i][y] == 'X':
                    flag = False
                    break
            if flag:
                x -= int(num)
        if direction == 'S':
            flag = True
            for i in range(1, int(num) + 1):
                if x + i >= n:
                    flag = False
                    break
                elif park[x + i][y] == 'X':
                    flag = False
                    break
            if flag:
                x += int(num)
        if direction == 'W':
            flag = True
            for i in range(1, int(num) + 1):
                if y - i < 0:
                    flag = False
                    break
                if park[x][y - i] == 'X':
                    flag = False
                    break
            if flag:
                y -= int(num)
        if direction == 'E':
            flag = True
            for i in range(1, int(num) + 1):
                if y + i >= m:
                    flag = False
                    break
                elif park[x][y + i] == 'X':
                    flag = False
                    break
            if flag:
                y += int(num)
    answer.append(x)
    answer.append(y)
    return answer