import sys
input = sys.stdin.readline

def dfs(i):
  global ans
  if i == n:
    ans += 1
    return 

  for j in range(n):
    if visited_column[j] == 0 and visited_asc[i + j] == 0 and visited_desc[i - j] == 0:
      visited_column[j] = 1
      visited_asc[i + j] = 1
      visited_desc[i - j] = 1
      dfs(i + 1)
      visited_column[j] = 0
      visited_asc[i + j] = 0
      visited_desc[i - j] = 0
      

n = int(input())
ans = 0

visited_column = [0] * n
visited_asc = [0] * (2 * n)
visited_desc = [0] * (2 * n)


dfs(0)
print(ans)
