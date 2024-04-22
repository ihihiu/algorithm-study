from itertools import permutations

n, m = map(int, input().split())

array = [i for i in range(1, n + 1)]

per = permutations(array, m)

for i in per:
  print(str(i).replace('(', '').replace(',', '').replace(')', ''))
