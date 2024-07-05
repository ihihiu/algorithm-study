n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

def DFS(depth, tmp):
  if depth == m:
    print(' '.join(map(str, tmp)))
  for i in range(n):
    if visited[i] == 0:
      visited[i] = 1
      DFS(depth + 1, tmp + [nums[i]])
      visited[i] = 0


visited = [0] * n
DFS(0, [])

