n = int(input())
arr = list(map(int, input().split()))
m = int(input())
search = list(map(int, input().split()))

arr = set(arr)

for s in search:
  if s in arr:
    print(1, end = ' ')
  else:
    print(0, end = ' ')