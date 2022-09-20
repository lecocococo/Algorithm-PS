import copy
import sys
sys.setrecursionlimit(100000)


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
        
        for i in range(n):
            for j in range(n):
                if arr[i][j] != -1 and not come[i][j]:
                    come[i][j] = True

                    dfs(arr, i, j, come)

                    c += 1

        if cnt < c:
            cnt = c
    
    return cnt


def dfs(arr, x, y, visited):
    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if not check(nx, ny, N) or visited[nx][ny]:
            continue
            # return
        dfs(arr, nx, ny, visited)


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
