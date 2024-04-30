k = int(input())
array = list(input().split())

result = ''
max_ans = ''
min_ans = ''

visited = [False] * 10

def check(a, b, x):
  if x == '<':
    return a < b
  else:
    return a > b

def dfs(depth, result):
  global min_ans, max_ans
  if depth == k + 1:
    if len(min_ans) == 0:
      min_ans = result
    else:
      max_ans = result
    return 

  for i in range(10):
    if not visited[i]:
      if depth == 0 or check(result[-1], str(i), array[depth - 1]):
        visited[i] = True
        dfs(depth + 1, result + str(i))
        visited[i] = False

dfs(0, '')
print(max_ans)
print(min_ans)
        