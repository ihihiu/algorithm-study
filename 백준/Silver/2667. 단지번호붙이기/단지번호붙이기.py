n = int(input())

graph = []
for _ in range(n):
  graph.append(list(map(int, input())))

visited = [[False] * (n) for _ in range(n)]


def dfs(x, y, count):
  if x < 0 or y < 0 or x >= n or y >= n:
    return False
  if graph[x][y] == 1 and visited[x][y] == False:
    visited[x][y] = True
    graph[x][y] = count
    dfs(x - 1, y, count)
    dfs(x + 1, y, count)
    dfs(x, y - 1, count)
    dfs(x, y + 1, count)
    return True
  return False


count = 0
for i in range(n):
  for j in range(n):
    if graph[i][j] == 1 and visited[i][j] == False:
      count += 1
      dfs(i, j, count)


print(count)

result = [0] * (count + 1)

for i in range(n):
  for j in range(n):
    if graph[i][j] != 0: 
      result[graph[i][j]] = result[graph[i][j]] + 1

result.sort()


for i in range(1, count + 1):
  print(result[i])

