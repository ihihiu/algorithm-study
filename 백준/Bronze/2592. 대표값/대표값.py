graph = [int(input()) for _ in range(10)]

# 10, 20, 30, ..., 1000
# 1, 2, 3, ...., 100
dp = [0] * 101


sum = 0
for num in graph:
  sum += num
  dp[num // 10] += 1

print(sum // 10)
print(dp.index(max(dp)) * 10)