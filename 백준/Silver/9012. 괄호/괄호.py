import sys
input = sys.stdin.readline

n = int(input())

for _ in range(n):
  array = input().rstrip()
  stack = []
  ans = 'YES'
  for a in array:
    if a == '(':
      stack.append('(')
    else:
      if len(stack) == 0:
        ans = 'NO'
        break
      else:
        stack.pop()
  if ans == 'NO':
    print('NO')
  else:
    if len(stack) == 0:
      print('YES')
    else:
      print('NO')
  
  

  