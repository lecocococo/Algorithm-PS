from collections import deque


def bfs(x):
    q = deque()
    q.append([x, 0])
    visited = [False]*(N+1)
    visited[x] = True
    su = 0
    while q:
        val, cnt = q.popleft()
        su += cnt
        for p in graph[val]:
            if not visited[p]:
                visited[p] = True
                q.append([p, cnt + 1])
    return su


N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
# print(graph)

val = 2**31 - 1
answer = 0
for i in range(1, N+1):
    temp = bfs(i)
    if temp < val:
        val = temp
        answer = i
print(answer)
