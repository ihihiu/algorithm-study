import sys
input = sys.stdin.readline

n, k = map(int, input().split())

arr = list(map(int, input().split()))

sum = 0
for i in range(k):
  sum += arr[i]

max = sum
for i in range(k, n):
  sum = sum + (arr[i] - arr[i - k])
  if sum > max:
    max = sum

print(max)