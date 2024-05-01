import sys
input = sys.stdin.readline

l, c = map(int, input().split())

alphabets = input().split()
alphabets.sort()
aeiou = ['a', 'e', 'i', 'o', 'u']
visited = [False] * c

ans = []

def check(arr):
  vowels = 0
  consonant = 0
  for a in arr:
    if a in aeiou:
      vowels += 1
    else:
      consonant += 1
  return vowels >= 1 and consonant >= 2
      

def dfs(depth, start):
  if depth == l:
    if check(ans):
      print(''.join(ans))
    return 

  for i in range(start, c):
    if not visited[i]:
      visited[i] = True
      ans.append(alphabets[i])
      dfs(depth + 1, i + 1)
      visited[i] = False
      ans.pop()

dfs(0, 0)
