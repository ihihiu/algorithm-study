from collections import deque
import sys

input = sys.stdin.readline

for _ in range(int(input())):
  n, m = map(int, input().split())
  array = list(map(int, input().split()))
  ans = 0

  queue = deque()
  for i in range(n):
    queue.append((array[i], i))

  while queue:
    ord, idx = queue.popleft()
    
    if ord >= max(array):
      ans += 1
      array.remove(ord)
      if idx == m:
        break
    else:
      queue.append((ord, idx))

  print(ans)

