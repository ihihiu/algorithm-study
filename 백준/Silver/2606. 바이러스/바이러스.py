n = int(input())
m = int(input())

visited = [False] * (n + 1)

graph =[[] for _ in range(n + 1)]

for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

cnt = 0

def dfs(start):
  global cnt
  cnt += 1
  visited[start] = True
  for i in graph[start]:
    if visited[i] == False:
      dfs(i)


dfs(1)
print(cnt - 1)