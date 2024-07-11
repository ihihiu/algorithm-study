import sys
sys.setrecursionlimit(1000000)

def dfs(x, y):
    global res
    graph[x][y] = 0
    res += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx <n and 0 <= ny < m and graph[nx][ny] == 1:
            dfs(nx, ny)
        
 
    


n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cnt = 0
max = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            cnt += 1
            res = 0
            dfs(i, j)
            if res > max:
                max = res

print(cnt)
print(max)