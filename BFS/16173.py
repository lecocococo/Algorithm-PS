from collections import deque

dx = [0, 1]
dy = [1, 0]


def bfs():
    q = deque()
    q.append((0, 0))
    visited = [[False] * N for _ in range(N)]
    visited[0][0] = True

    while q:
        x, y = q.popleft()
        if m[x][y] == -1:
            return True
        for i in range(2):
            nx = x + dx[i] * m[x][y]
            ny = y + dy[i] * m[x][y]

            if not (0 <= nx < N and 0 <= ny < N):
                continue
            if visited[nx][ny]:
                continue
            visited[nx][ny] = True
            q.append((nx, ny))
    return False


N = int(input())
m = [list(map(int, input().split())) for _ in range(N)]
if bfs():
    print("HaruHaru")
else:
    print("Hing")
