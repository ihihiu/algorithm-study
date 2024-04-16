n = int(input())

array = list(map(int, input().split()))

dp = [0] * (n + 1)
dp[0] = 0

for i in range(n):
  if array[i] == 0:
    dp[i + 1] = 0
  else:
    dp[i + 1] = dp[i] + 1

print(sum(dp))

