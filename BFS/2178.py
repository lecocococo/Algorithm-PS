# 2178번

# 중복을 최소화 하기 위해 큐에append 할 때 visited를 True로 한다!!!
from collections import deque


def check(x, y):
    return 0 <= x < N and 0 <= y < M


def solution(N, M):
    q = deque()
    q.append([0, 0, 1])
    visited[0][0] = True
    while q:
        val = q.popleft()
        x = val[0]
        y = val[1]
        cnt = val[2]

        # maze[x][y] = cnt

        if x == N-1 and y == M-1:
            return cnt
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # and (nx, ny) ==(N, M)
            if check(nx, ny) and not visited[nx][ny] and maze[nx][ny] == '1':
                visited[nx][ny] = True
                q.append([nx, ny, cnt + 1])


N, M = map(int, input().split())

maze = []
for i in range(N):
    line = input()
    temp = []
    for l in range(M):
        temp.append(line[l])
    maze.append(temp)
# print(maze)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

visited = [[False] * M for _ in range(N)]
# print(visited)
answer = solution(N, M)
print(answer)
