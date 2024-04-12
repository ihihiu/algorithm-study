for _ in range(int(input())):
  k = int(input())
  n = int(input())

  graph = [[0] * (n + 1) for _ in range(k + 1)]

  for i in range(1, n + 1):
    graph[0][i] += i


  for j in range(1, k + 1):
    for l in range(1, n + 1):
      graph[j][l] = graph[j][l - 1] + graph[j - 1][l]


  print(graph[k][n])
  