from collections import deque
import copy
import sys
sys.setrecursionlimit(100000)


# BFS
def solution(n, arr, mx, cnt):
    visited = [[False]*n for _ in range(n)]

    for num in range(0, mx):
        c = 0
        for i in range(n):
            for j in range(n):
                if arr[i][j] <= num:
                    # arr[i][j] = -1
                    visited[i][j] = True

        come = copy.deepcopy(visited)

        q = deque([])
        for i in range(n):
            for j in range(n):
                if arr[i][j] != -1 and not come[i][j]:

                    bfs(arr, i, j, come)

                    c += 1

        if cnt < c:
            cnt = c
    return cnt


def bfs(arr, x, y, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not check(nx, ny, N) or visited[nx][ny]:
                continue
                # return
            q.append((nx, ny))
            visited[nx][ny] = True


def check(x, y, n):
    return 0 <= x < n and 0 <= y < n


N = int(input())
arr = []
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
mx = -1
cnt = 0
for _ in range(N):
    temp = list(map(int, input().split()))
    mx = max(mx, max(temp))
    arr.append(temp)
answer = solution(N, arr, mx, cnt)
print(answer)
