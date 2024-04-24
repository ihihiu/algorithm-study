croatias = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

word = input()

for croatia in croatias:
  word = word.replace(croatia, "*")

print(len(word))
      