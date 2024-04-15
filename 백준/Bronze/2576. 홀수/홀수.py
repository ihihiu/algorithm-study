sum = 0
min_value = 101

for _ in range(7):
  num = int(input())
  if num % 2 != 0:
    sum += num
    min_value = min(min_value, num)
  

if sum == 0:
  print(-1)
else:
  print(sum)
  print(min_value)