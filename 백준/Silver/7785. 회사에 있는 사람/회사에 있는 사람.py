dict = {}
for _ in range(int(input())):
  a = input().split()
  dict[a[0]] = a[1]

sorted_dict = sorted(dict.items(), key = lambda x: x[0], reverse=True)

for key, value in sorted_dict:
  if value == 'enter':
    print(key)
    