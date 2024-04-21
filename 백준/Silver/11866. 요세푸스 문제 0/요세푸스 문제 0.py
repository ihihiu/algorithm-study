from collections import deque

n, k = map(int, input().split())
queue = deque()
for i in range(1, n + 1):
  queue.append(i)

ans = []
while queue:
  for _ in range(k -1):
    queue.append(queue.popleft())
  ans.append(queue.popleft())

print(str(ans).replace('[', '<').replace(']', '>'))

