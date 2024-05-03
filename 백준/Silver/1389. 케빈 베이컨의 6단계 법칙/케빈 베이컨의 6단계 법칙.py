from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]
INF = int(1e9)
ans = []

for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)


for i in range(1, n + 1):
  distance = [INF] * (n + 1)
  distance[i] = 0
  sum = 0
  queue = deque()
  queue.append(i)
  while queue:
    now = queue.popleft()
    for i in graph[now]:
      if distance[i] != INF:
        continue
      cost = distance[now] + 1
      if cost < distance[i]:
        distance[i] = cost
        queue.append(i)

  for j in range(1, n + 1):
   sum += distance[j]
  ans.append(sum)

print(ans.index(min(ans)) + 1)
  