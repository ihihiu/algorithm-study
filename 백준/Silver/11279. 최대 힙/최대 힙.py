import heapq
import sys
input = sys.stdin.readline

n = int(input())

queue = []
for _ in range(n):
  command = int(input())
  if command == 0:
    if len(queue) == 0:
      print(0)
    else:
      print(-heapq.heappop(queue))
  else:
    heapq.heappush(queue, -command)
    