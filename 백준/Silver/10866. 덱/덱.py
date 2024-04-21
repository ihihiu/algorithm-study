import sys
from collections import deque
input = sys.stdin.readline

array = deque()
n = int(input())

for _ in range(n):
  command = input().split()
  if command[0] == 'push_front':
    array.insert(0, command[1])
  elif command[0] == 'push_back':
    array.append(command[1])
  elif command[0] == 'pop_front':
    if len(array) == 0:
      print(-1)
    else:
      print(array.popleft())
  elif command[0] == 'pop_back':
    if len(array) == 0:
      print(-1)
    else:
      print(array.pop())
  elif command[0] == 'size':
    print(len(array))
  elif command[0] == 'empty':
    if len(array) == 0:
      print(1)
    else:
      print(0)
  elif command[0] == 'front':
    if len(array) == 0:
      print(-1)
    else:
      print(array[0])
  elif command[0] == 'back':
    if len(array) == 0:
      print(-1)
    else:
      print(array[-1])


    
    