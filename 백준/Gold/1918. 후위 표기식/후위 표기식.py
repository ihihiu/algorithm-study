s = input()

stack = []

ans = ''
for x in s:
  if 65 <= ord(x) <= 90:
    ans += x
  elif x == '(':
    stack.append(x)
  elif x == '*' or x == '/':
    while stack and (stack[-1] == '*' or stack[-1] == '/'):
      ans += stack.pop()
    stack.append(x)
  elif x == '+' or x == '-':
    while stack and stack[-1] != '(':
      ans += stack.pop()
    stack.append(x)
  elif x == ')':
    while stack and stack[-1] != '(':
      ans += stack.pop()
    stack.pop()

while stack:
  ans += stack.pop()

print(ans)