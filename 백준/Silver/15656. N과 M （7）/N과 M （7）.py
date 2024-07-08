def dfs(depth, tmp):
  if depth == m:
    print(*tmp)
  else:
    for num in nums:
      dfs(depth + 1, tmp + [num])
    
n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))

dfs(0, [])