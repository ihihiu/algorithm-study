def dfs(depth, start, tmp):
    if depth == m:
        print(*tmp)
    else:
        for i in range(start, n):
            dfs(depth + 1, i, tmp + [a[i]])
            


n, m = map(int, input().split())
a = sorted(list(map(int, input().split())))

dfs(0, 0, [])
