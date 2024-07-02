n = int(input())
s = input()
nums = []
for _ in range(n):
  nums.append(int(input()))

stack = []
for x in s:
  if x.isalpha():
    index = ord(x) - ord('A')
    stack.append(nums[index])
  else:
    x2 = stack.pop()
    x1 = stack.pop()
    if x == '+':
      stack.append(x1 + x2)
    elif x == '-':
      stack.append(x1 - x2)
    elif x == '*':
      stack.append(x1 * x2)
    elif x == '/':
      stack.append(x1 / x2)
      
print("{:.2f}".format(stack.pop()))