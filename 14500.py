# 신기하게도 dfs로 탐색하면 'ㅗ' 모양 말고 다 탐색가능
# ㅗ 모양은 idx = 1(2개가 선택됬을때) 자신을 기준으로 다시 dfs를 들어가면 계산가능
import sys


def dfs(r, c, idx, total):
    global answer

    if answer >= total + mx * (3 - idx):  # 가지치기
        return
    if idx == 3:
        answer = max(answer, total)
        return
    else:
        for i in range(4):
            sr = r + search_range[i][0]
            sc = c + search_range[i][1]
            if 0 <= sr < N and 0 <= sc < M and visited[sr][sc] == 0:
                if idx == 1:
                    visited[sr][sc] = 1
                    dfs(r, c, idx + 1, total + arr[sr][sc])
                    visited[sr][sc] = 0
                visited[sr][sc] = 1
                dfs(sr, sc, idx + 1, total + arr[sr][sc])
                visited[sr][sc] = 0


N, M = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visited = [([0] * M) for _ in range(N)]

search_range = [[0, -1], [-1, 0], [0, 1], [1, 0]]
mx = max(map(max, arr))
answer = 0

for r in range(N):
    for c in range(M):
        visited[r][c] = 1
        dfs(r, c, 0, arr[r][c])
        visited[r][c] = 0

print(answer)
