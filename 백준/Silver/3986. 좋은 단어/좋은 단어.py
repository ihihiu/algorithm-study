N = int(input())

ans = 0

for _ in range(N):
  arr = input()
  stack = []
  for a in arr:
    if len(stack) == 0:
      stack.append(a)
    elif stack[-1] == a:
      stack.pop()
    else:
      stack.append(a)

  if len(stack) == 0:
    ans += 1

print(ans)
      