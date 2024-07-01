for _ in range(int(input())):
  n = int(input())
  arr = list(map(int, input().split()))

  total = 0
  maxPrice = 0
  for i in range(len(arr) - 1, -1, -1):
    if arr[i] < maxPrice:
      total += maxPrice - arr[i]
    else:
      maxPrice = arr[i]

  print(total)