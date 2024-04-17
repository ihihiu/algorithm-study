n = int(input())

ans = 0
for _ in range(n):
  dice = [0] * 7
  result = 0
  array = list(map(int, input().split()))
  for a in array:
    dice[a] += 1
  if max(dice) == 4:
    result = 50000 + 5000 * dice.index(4)
  elif max(dice) == 3:
    result = 10000 + 1000 * dice.index(3)
  elif max(dice) == 2 and dice.count(2) == 2:
    cnt = 0
    for i in range(1, 7):
      if dice[i] == 2:
        cnt += i
    result = 2000 + 500 * cnt
  elif max(dice) == 2:
    result = 1000 + 100 * dice.index(2)
  else:
    for i in range(6, 0, -1):
      if dice[i] == 1:
        result = i * 100
        break
  ans = max(result, ans)

print(ans)