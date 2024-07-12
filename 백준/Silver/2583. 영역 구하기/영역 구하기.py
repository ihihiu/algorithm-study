import sys
sys.setrecursionlimit(1000000)

def dfs(x, y):
    global cnt
    graph[x][y] = 1
    cnt += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 0:
            dfs(nx, ny)
           
    


m, n, k = map(int, input().split())
dots = [list(map(int, input().split())) for _ in range(k)]

graph = [[0] * n for _ in range(m)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for c1, r1, c2, r2 in dots:
    for i in range(r1, r2):
        for j in range(c1, c2):
            graph[i][j] = 1

ans = []
for i in range(m):
    for j in range(n):    
        if graph[i][j] == 0:
            cnt = 0
            dfs(i, j)
            ans.append(cnt)
            
ans.sort()
print(len(ans))
print(*ans)
