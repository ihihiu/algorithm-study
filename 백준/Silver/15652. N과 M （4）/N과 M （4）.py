n, m = map(int, input().split())
temp = []

def dfs(depth, start):
  if depth == m:
    print(' '.join(map(str, temp)))
    return

  for i in range(start, n + 1):
    temp.append(i)
    dfs(depth + 1, i)
    temp.pop()


dfs(0, 1)