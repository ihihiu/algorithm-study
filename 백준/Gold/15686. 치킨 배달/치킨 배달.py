import sys
input = sys.stdin.readline
n, m = map(int, input().split())

graph = []
for _ in range(n):
  graph.append(list(map(int, input().split())))

chickens = []
houses = []
for i in range(n):
  for j in range(n):
    if graph[i][j] == 1:
      houses.append((i, j))
    if graph[i][j] == 2:
      chickens.append((i, j))

length = len(chickens)
visited = [False] * length


min_value = int(1e9)
run = []

def dfs(depth, start):
  global min_value
  global total
  if depth == m:
    total = 0
    for house in houses:
      now_min = int(1e9)
      for r in run:
        now_min = min(now_min, abs(house[0] - r[0]) + abs(house[1] - r[1]))
      total += now_min
    min_value = min(min_value, total)
    return

  for i in range(start, length):
    if not visited[i]:
      run.append(chickens[i])
      visited[i] = True
      dfs(depth + 1, i + 1)
      visited[i] = False
      run.pop()
      

dfs(0, 0)

print(min_value)