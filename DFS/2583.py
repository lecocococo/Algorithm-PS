# 2583번

import sys
sys.setrecursionlimit(100000)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

M, N, K = map(int, input().split())

m = [[0] * N for _ in range(M)]


def dfs(x, y):
    # if m[x][y] == 1:
    #     return
    global cnt
    m[x][y] = cnt + 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if check(nx, ny) and m[nx][ny] == 0:

            cnt += 1
            dfs(nx, ny)
            m[nx][ny] = max(cnt, m[nx][ny])
    return cnt


def check(x, y):
    return 0 <= x < M and 0 <= y < N


for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())

    for i in range(y1, y2):
        for j in range(x1, x2):
            # print(i, j)
            m[i][j] = 1

answer = 0
cnt = 0
arr = []
for i in range(M):
    for j in range(N):
        if m[i][j] == 0:

            cnt = 0
            answer += 1
            arr.append(dfs(i, j) + 1)

print(answer)
arr = sorted(arr)
for a in arr:
    print(a, end=' ')
