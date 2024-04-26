n, k = map(int, input().split())

coins = []
for _ in range(n):
  coins.append(int(input()))

coins.reverse()

ans = 0
for coin in coins:
  if k == 0:
    break
  if k // coin != 0:
    ans += k // coin
    k -= coin * (k // coin)


print(ans)