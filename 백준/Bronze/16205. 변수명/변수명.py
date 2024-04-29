n, v = map(str, input().split())

if n == '1':
  print(v)
  v1 = v
  i = 0
  while True:
    if v1[i].isupper():
      v1 = v1[:i] + '_' + v1[i].lower() + v1[i + 1:]
      i += 2
    else:
      i += 1
    if i >= len(v1):
      break
  print(v1)
  print(v[0].upper() + v[1:])

if n == '2':
  v2 = v
  a = len(v2)
  for i in range(a):
    if v2[i] == '_':
      v2 = v2[:i + 1] + v[i + 1].upper() + v[i+2:]
  v2 = v2.replace('_', '')
  print(v2)
  print(v)
  print(v2[0].upper() + v2[1:])

if n == '3':
  print(v[0].lower() + v[1:])
  v3 = v
  i = 0
  while True:
    if v3[i].isupper():
      v3 = v3[:i] + '_' + v3[i].lower() + v3[i+1:]
    else:
      i += 1
    if i >= len(v3):
      break

  print(v3[1:])
  print(v)