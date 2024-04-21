cnt = dict()

for _ in range(int(input())):
  x = input()
  if x in cnt:
    cnt[x] += 1
  else:
    cnt[x] = 1

max_value = max(cnt.values())

result = []

for key, value in cnt.items():
  if value == max_value:
    result.append(key)

result.sort()
print(result[0])
  

    