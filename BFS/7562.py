from collections import deque

dx = [-1, -2, -2, -1, 1, 2, 2, 1]
dy = [-2, -1, 1, 2, 2, 1, -1, -2]


def bfs(i, j):
    q = deque()
    q.append([i, j, 0])
    visited[i][j] = True
    while q:
        val = q.popleft()
        x = val[0]
        y = val[1]
        cnt = val[2]
        if x == ex and y == ey:
            return cnt
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if check(nx, ny) and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx, ny, cnt + 1])


def check(x, y):
    return 0 <= x < L and 0 <= y < L


C = int(input())

for _ in range(C):
    L = int(input())
    visited = [[False]*L for _ in range(L)]
    sx, sy = map(int, input().split())
    ex, ey = map(int, input().split())
    print(bfs(sx, sy))
