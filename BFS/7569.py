from collections import Counter, deque


def bfs(arr):
    while q:

        h, x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if check1(nx, ny) and arr[h][nx][ny] == 0:
                q.append([h, nx, ny])
                arr[h][nx][ny] = arr[h][x][y] + 1

        for i in range(2):
            nh = h + dh[i]

            if check2(nh) and arr[nh][x][y] == 0:
                q.append([nh, x, y])
                arr[nh][x][y] = arr[h][x][y] + 1


def check1(x, y):
    return 0 <= x < N and 0 <= y < M


def check2(h):
    return 0 <= h < H


M, N, H = map(int, input().split())
dh = [1, -1]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
arr = []
q = deque()

for k in range(H):
    temp = []
    for j in range(N):
        temp.append(list(map(int, input().split())))
        for i in range(M):
            if temp[j][i] == 1:
                q.append([k, j, i])
    arr.append(temp)

bfs(arr)
answer = 0
for i in arr:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit(0)
        answer = max(answer, max(j))
print(answer-1)
