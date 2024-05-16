n = int(input())

num2 = 0
num5 = 0
for i in range(2, n + 1):
  while True:
    if i % 2 == 0:
      i //= 2
      num2 += 1
    else:
      break

  while True:
    if i % 5 == 0:
      i //= 5
      num5 += 1
    else:
      break

print(min(num2, num5))