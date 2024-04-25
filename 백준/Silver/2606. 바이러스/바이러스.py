from collections import deque

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

visited = [False] * (n + 1)

cnt = 0
q = []
q = deque()
q.append(1)

visited[1] = True

while q:
  now = q.popleft()
  for i in graph[now]:
    if visited[i] == False:
      visited[i] = True
      q.append(i)

for v in visited:
  if v == True:
    cnt += 1


print(cnt - 1)
    


