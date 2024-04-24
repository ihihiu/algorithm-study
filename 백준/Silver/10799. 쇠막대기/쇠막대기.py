array = input()

stack = []

cnt = 0
for i in range(len(array)):
  if array[i] == '(':
    stack.append('(')
  elif array[i] == ')':
    if array[i - 1] == '(':
      stack.pop()
      cnt += len(stack)
    else:
      stack.pop()
      cnt += 1
print(cnt)