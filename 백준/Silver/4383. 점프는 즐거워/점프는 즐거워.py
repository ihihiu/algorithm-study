while True:
  try:
    arr = list(map(int, input().split()))
    n = arr[0]
    check = [0] * n
    check[0] = 1

    answer = 'Jolly'
    for i in range(1, n - 1):
      sub = abs(arr[i] - arr[i + 1])
      if sub >= n or check[sub] != 0:
        answer = 'Not jolly'
        break
      else:
        check[sub] += 1

    print(answer)

  except:
    break



