import sys
input = sys.stdin.readline

for _ in range(int(input())):
  a, b = map(int, input().split())
  if a > b:
    a, b = b, a
  while True:
    if a == b:
      print(10 * a)
      break
    elif a > b:
      a //= 2
    else:
      b //= 2

  
      
    