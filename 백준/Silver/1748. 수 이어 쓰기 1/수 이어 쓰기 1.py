n = input()

cnt = 0


for i in range(1, len(n)):
  cnt += i * 9 * 10 ** (i - 1)

cnt += (int(n) - 10 ** (len(n) - 1) + 1) * len(n)

print(cnt)



