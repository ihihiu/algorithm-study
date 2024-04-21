from itertools import combinations

array = []
for i in range(9):
  array.append(int(input()))

combis = list(combinations(array, 7))

result = []
for combi in combis:
  sum = 0
  for a in combi:
    sum += a
  if sum == 100:
    result = list(combi)
    break

result.sort()
for a in result:
  print(a)

