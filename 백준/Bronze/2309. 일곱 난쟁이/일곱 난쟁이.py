from itertools import combinations

array = []
for _ in range(9):
  array.append(int(input()))

combi = combinations(array, 7)
result = []

for com in combi:
  if sum(com) == 100:
    result = list(com)
    break

result.sort()
for i in result:
  print(i)