def get_distance(tmp):
    global ans
    total = 0
    for hx, hy in house:
        distance = int(1e9)
        for px, py in tmp:
            d = abs(hx - px) + abs(hy - py)
            if d < distance:
                distance = d
        total += distance
    ans = min(ans, total)


def dfs(depth, start, tmp):
    if depth == m:
         get_distance(tmp)
    else:
        for i in range(start, len(pizza)):
            dfs(depth + 1, i + 1, tmp + [pizza[i]])


n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

pizza = []
house = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            house.append((i, j))
        elif graph[i][j] == 2:
            pizza.append((i, j))

ans = int(1e9)
dfs(0, 0, [])
print(ans)