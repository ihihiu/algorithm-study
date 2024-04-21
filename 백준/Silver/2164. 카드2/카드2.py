from collections import deque

n = int(input())
array = deque()
for i in range(1, n + 1):
  array.append(i)

for _ in range(n - 1):
  array.popleft()
  array.append(array.popleft())

print(array.popleft())