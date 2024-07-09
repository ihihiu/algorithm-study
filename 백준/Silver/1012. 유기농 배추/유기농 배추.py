import sys
sys.setrecursionlimit(100000)

def dfs(x, y):
    graph[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
            dfs(nx, ny)
    


for _ in range(int(input())):
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]
    for _ in range(k):
        a, b = map(int, input().split())
        graph[b][a] = 1
    
    cnt = 0
    
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                dfs(i, j)
                cnt += 1
    print(cnt)