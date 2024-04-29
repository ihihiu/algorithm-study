from itertools import permutations

n = int(input())
a = list(map(int, input().split()))
max_value = 0
per = permutations(a, n)

for p in per:
  sum = 0
  for i in range(n - 1):
    sum += abs(p[i + 1] - p[i])
  max_value = max(sum, max_value)

print(max_value)