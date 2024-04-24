while True:
  sentence = input()
  stack = []
  if sentence == '.':
    break
  
  for sen in sentence:
    if sen == '(' or sen == '[':
      stack.append(sen)
    elif sen == ')':
      if len(stack) != 0 and stack[-1] == '(':
        stack.pop()
      else:
        stack.append(sen)
        break
    elif sen == ']':
      if len(stack) != 0 and stack[-1] == '[':
        stack.pop()
      else:
        stack.append(sen)
        break

  if len(stack) == 0:
    print('yes')
  else:
    print('no')