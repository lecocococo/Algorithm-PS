from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

N = int(input())


m = []
for i in range(N):
    m.append(list(map(int, input().split())))

sx, sy = 0, 0
baby_shark = 2
answer = 0
cnt = 0
for i in range(N):
    for j in range(N):
        if m[i][j] == 9:
            m[i][j] = 0
            sx, sy = i, j
            break


def check(x, y):
    return 0 <= x < N and 0 <= y < N


# 아기 상어가 갈수 있는 곳을 다 저장후 문제 제시에 따라 정렬 후
# 가장 첫 번째 값을 통해 다시 탐색
# 먹을 수 있는 물고기를 찾은 횟수까지만 탐색을 수행하도록 함
# (3번 움직여서 먹을수 있는게 발견되면 그게 가장 가까운 물고기 이기 때문에
# 거리 4이상의 물고기는 볼 필요가 없다)
# 같은 거리의 물고기가 여러 개라면 정렬
while True:

    q = deque()
    q.append([sx, sy, 0])
    visited = [[False] * N for _ in range(N)]
    flag = 1e9
    fish = []
    while q:
        x, y, count = q.popleft()

        if count > flag:
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if not check(nx, ny):
                continue
            if m[nx][ny] > baby_shark or visited[nx][ny]:
                continue
            if m[nx][ny] != 0 and m[nx][ny] < baby_shark:
                fish.append([nx, ny, count + 1])
                flag = count
            visited[nx][ny] = True
            q.append([nx, ny, count + 1])
    if len(fish) > 0:
        fish.sort()
        x, y, move = fish[0][0], fish[0][1], fish[0][2]
        answer += move
        cnt += 1
        m[x][y] = 0
        if cnt == baby_shark:
            baby_shark += 1
            cnt = 0
        sx, sy = x, y
    else:
        break
print(answer)
