import sys
input = sys.stdin.readline

array = []
for _ in range(int(input())):
  array.append(int(input()))

array.sort(reverse = True)
ans = -1
for i in range(len(array) - 2):
  if array[i] < array[i + 1] + array[i + 2]:
    ans =  array[i] + array[i + 1] + array[i + 2]
    break

print(ans)