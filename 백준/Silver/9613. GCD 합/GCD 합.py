from itertools import combinations
from math import gcd

for _ in range(int(input())):
  ans = 0
  array = list(map(int, input().split()))
  combs = combinations(array[1:], 2)
  for x, y in combs:
    ans += gcd(x, y)
  print(ans)
