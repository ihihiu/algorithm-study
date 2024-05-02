import sys
input = sys.stdin.readline

n, s = map(int, input().split())
array = list(map(int, input().split()))
ans = 0

def dfs(depth, total, cnt):
  global ans
  if depth == n:
    if total == s and cnt > 0:
      ans += 1
    return

  dfs(depth + 1, total + array[depth], cnt + 1)
  dfs(depth + 1, total, cnt)

dfs(0, 0, 0)
print(ans)

  