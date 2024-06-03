n = int(input())
ans = []
count = 1
stack = []
flag = True

for _ in range(n):
  num = int(input())
  while count <= num:
    stack.append(count)
    ans.append("+")
    count += 1

  if stack[-1] == num:
    stack.pop()
    ans.append("-")
  else:
    flag = False
    break

if not flag:
  print("NO")
else:
  for a in ans:
    print(a)
    
  
  