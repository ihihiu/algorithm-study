from collections import deque

n, k = map(int, input().split())

ans = []
array = deque()
for i in range(1, n + 1):
  array.append(i)

while array:
  for _ in range(k - 1):
    array.append(array.popleft())
  ans.append(array.popleft())

print(str(ans).replace('[', '<').replace(']', '>'))