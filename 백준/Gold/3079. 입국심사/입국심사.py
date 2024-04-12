n, m = map(int, input().split())

time = []
for _ in range(n):
  time.append(int(input()))

start = min(time)
end = max(time) * m

ans = end

while start <= end:
  mid = (start + end) // 2
  result = 0
  for t in time:
    result += mid // t
  if result >= m:
    ans = min(ans, mid)
    end = mid - 1
  else:
    start = mid + 1
  
print(ans)