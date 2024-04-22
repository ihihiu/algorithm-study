from itertools import combinations

n, m = map(int, input().split())

array = [i for i in range(1, n + 1)]

combi = combinations(array, m)

for i in combi:
  print(str(i).replace('(', '').replace(',', '').replace(')', ''))