import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    q = deque()
    q.append(start)
    # visited = [-1] * (V+1)
    visited[start] = 1

    while q:
        val = q.popleft()

        for i in graph[val]:
            if visited[i] == 0:
                q.append(i)
                visited[i] = -1 * visited[val]
            elif visited[i] == visited[val]:
                # if c == visited[i]:
                return "NO"

    return "YES"


K = int(input())
for _ in range(K):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V+1)]
    visited = [0] * (V+1)
    for i in range(E):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    # print(graph)
    for i in range(1, V + 1):
        if visited[i] == 0:
            result = bfs(i)
            if result == "NO":
                break
    print('YES' if result == 'YES' else 'NO')
