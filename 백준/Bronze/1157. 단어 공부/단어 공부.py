alphabet = input().upper()

# 65 - 90

dp = [0] * 91

for alpha in alphabet:
  dp[ord(alpha)] += 1

if dp.count(max(dp)) != 1:
  print('?')
else:
  print(chr(dp.index(max(dp))))
