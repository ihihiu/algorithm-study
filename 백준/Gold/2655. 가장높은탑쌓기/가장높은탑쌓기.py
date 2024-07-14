n = int(input())

arr = []
dp = [0] * n
for i in range(n):
    arr.append(list(map(int, input().split())) + [i + 1])

arr.sort(reverse = True)
dp[0] = arr[0][1]


for i in range(1, n):
    dp[i] = arr[i][1]
    for j in range(0, i):
        if arr[i][2] < arr[j][2]:
            dp[i] = max(dp[i], dp[j] + arr[i][1])

max = max(dp)
index = dp.index(max)

ans = []
while True:
    if max == dp[index]:
        ans.append(arr[index][-1])
        max -= arr[index][1]
    index -= 1
    if index == -1:
        break
print(len(ans))

for a in ans:
    print(a)