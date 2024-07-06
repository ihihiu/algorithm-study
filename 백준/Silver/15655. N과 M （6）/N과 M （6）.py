def DFS(depth, start, tmp):
    if depth == m:
        print(*tmp)
    
    else:
        for i in range(start, n):
            if visited[i] == 0:
                visited[i] = 1
                DFS(depth + 1, i + 1, tmp + [nums[i]])
                visited[i] = 0

                
n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
visited = [0] * n
DFS(0, 0, [])