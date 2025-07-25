import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

n, m, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
  a, b, c = map(int, input().split())
  graph[a].append((b, c))

def dijkstra(start):
  distance = [INF] * (n + 1)
  distance[start] = 0
  q = []
  heapq.heappush(q, (0, start))
  while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
      continue
    for i in graph[now]:
      cost = dist + i[1]
      if cost < distance[i[0]]:
        distance[i[0]] = cost
        heapq.heappush(q, (cost, i[0]))

  return distance

result = []
for d in dijkstra(x):
  result.append(d)

for i in range(n + 1):
  result[i] += dijkstra(i)[x]

result.pop(0)
print(max(result))
