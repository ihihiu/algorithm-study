import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y, h):
    Q = deque()
    Q.append((x, y))
    ch[x][y] = 1
    while Q:
        x, y = Q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and ch[nx][ny] == 0 and graph[nx][ny] >= h:
                Q.append((nx, ny))
                ch[nx][ny] = 1
                

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

ans = -1
for h in range(101):
    ch = [[0] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):    
            if graph[i][j] >= h and ch[i][j] == 0:
                bfs(i, j, h)
                cnt += 1
    if cnt > ans:
        ans = cnt
    if cnt == 0:
        break
                
print(ans)
            