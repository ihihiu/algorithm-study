import sys
input = sys.stdin.readline

r = int(input())
s = input()
n = int(input())
friends = [input() for _ in range(n)]


def calculate_score(x, y):
  if x == y:
    return 1
  else:
    if x =='R':
      if y == 'S':
        return 2
      else:
        return 0
    if x == 'S':
      if y == 'P':
        return 2
      else:
        return 0
    if x == 'P':
      if y == 'R':
        return 2
      else:
        return 0


score = 0
for i in range(n):
  for j in range(r):
    score += calculate_score(s[j], friends[i][j])
                  
print(score)

best_score = 0
for i in range(r):
  r_score, s_score, p_score = 0, 0, 0
  for j in range(n):
    r_score += calculate_score('R', friends[j][i])
    s_score += calculate_score('S', friends[j][i])
    p_score += calculate_score('P', friends[j][i])
  best_score += max(r_score, max(s_score, p_score ))
  
print(best_score)