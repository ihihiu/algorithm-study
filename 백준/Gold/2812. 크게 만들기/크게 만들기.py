n, k = map(int, input().split())
nums = list(map(int, input()))

stack = []
for num in nums:
    while stack and k != 0 and stack[-1] < num:
        stack.pop()
        k -= 1
    stack.append(num)
    

if k != 0:
    stack = stack[0:-k]
    
ans = ''.join(map(str, stack))
print(ans)