from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def bfs(red, blue):
    q = deque()
    redX, redY = red
    BlueX, BlueY = blue
    # print(redX, redY, BlueX, BlueY)
    q.append([redX, redY, BlueX, BlueY, 1])
    visited = [[[[False] * M for _ in range(N)]
                for _ in range(M)] for _ in range(N)]
    visited[redX][redY][BlueX][BlueY] = True
    while q:
        redX, redY, BlueX, BlueY, cnt = q.popleft()
        if cnt > 10:
            return -1
        for i in range(4):
            # 한번 움직임에 최대한 움직이도록
            newRedX, newRedY, rcnt = move(redX, redY, dx[i], dy[i])
            newBlueX, newBlueY, bcnt = move(BlueX, BlueY, dx[i], dy[i])

            # Blue가 먼저 들가면 안됨
            if board[newBlueX][newBlueY] != 'O':
                if board[newRedX][newRedY] == 'O':
                    return cnt
                # 공 2개가 겹치면 더 많이 움직인 공이 비켜줌
                if (newRedX, newRedY) == (newBlueX, newBlueY):
                    if rcnt > bcnt:
                        newRedX -= dx[i]
                        newRedY -= dy[i]
                    else:
                        newBlueX -= dx[i]
                        newBlueY -= dy[i]

                if not visited[newRedX][newRedY][newBlueX][newBlueY]:
                    visited[newRedX][newRedY][newBlueX][newBlueY] = True
                    q.append([newRedX, newRedY, newBlueX, newBlueY, cnt + 1])
    return -1


def move(x, y, dx, dy):
    count = 0
    # 다음이 벽이거나 현재위치가 O이 아닐때 까지(최대한 움직이도록)
    while board[x + dx][y + dy] != '#' and board[x][y] != "O":
        x += dx
        y += dy
        count += 1
    return x, y, count


N, M = map(int, input().split())
board = []


for i in range(N):
    temp = list(input())
    if 'R' in temp:
        val1 = [i, temp.index('R')]
    if 'B' in temp:
        val2 = [i, temp.index('B')]
    board.append(temp)

# print(val1, val2)
print(bfs(val1, val2))
