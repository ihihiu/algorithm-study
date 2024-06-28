n = int(input())
arr = list(map(int, input().split()))

m = int(input())
search = list(map(int, input().split()))

dict ={}
for a in arr:
  if a in dict.keys():
    dict[a] += 1
  else:
    dict[a] = 1


for s in search:
  if s in dict.keys():
    print(dict[s], end = ' ')
  else:
    print(0, end = ' ')