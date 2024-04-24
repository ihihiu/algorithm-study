array = []

for _ in range(int(input())):
  num = int(input())
  if num == 0:
    array.pop()
  else:
    array.append(num)

print(sum(array))