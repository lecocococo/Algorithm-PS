from collections import deque

LOG = 16

n = int(input())
parent = [[0]*LOG for _ in range(n+1)]  # 부모 노드 정보
d = [0] * (n+1)  # 각 노드까지의 깊이
c = [0] * (n+1)  # 각 노드 깊이가 계산되었는지 여부
graph = [[] for _ in range(n+1)]
p1, p2 = map(int, input().split())
M = int(input())


for i in range(M):
    a, b = list(map(int, input().split()))
    graph[a].append(b)
    graph[b].append(a)


def dfs(x, depth):  # 루트노드부터 출발하여 깊이를 구하는 함수
    c[x] = True
    d[x] = depth

    for y in graph[x]:
        if c[y]:
            continue
        parent[y][0] = x
        dfs(y, depth + 1)


# 전체 부모 관계를 설정하기
def set_parent(a):
    dfs(a, 0)  # 루트노드 1번부터 시작
    for i in range(1, LOG):
        for j in range(1, n+1):
            parent[j][i] = parent[parent[j][i-1]][i-1]


def lca(a, b):  # A와 B의 최소 공통 조상 찾기
    # B가 더 깊도록 설정
    if d[a] > d[b]:
        a, b = b, a
    # 깊이가 동일하도록
    # 11 차이라면 11을 이진수로 바꾸면 1011 2의 0승 1승 3승을 해서 깊이를 동일하게
    for i in range(LOG - 1, -1, -1):
        if d[b] - d[a] >= (1 << i):
            b = parent[b][i]
    # 부모가 같아지도록
    if a == b:
        return a

    for i in range(LOG-1, -1, -1):
        # 조상을 향해 거슬러 올라가기
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    # 부모가 찾고자 하는 조상
    return parent[a][0]


def bfs(a, p, cnt):
    q = deque()
    q.append([a, cnt])
    visited = [False] * (n+1)
    visited[1] = True
    ans = 0
    while q:
        v = q.popleft()
        if v[0] == p:
            ans = v[1]
            return ans
        for k in graph[v[0]]:
            if not visited[k]:
                visited[k] = True
                q.append([k, v[1] + 1])


set_parent(1)
# print(graph)
# print(parent)

for h in range(2, n):
    if parent[h][0] == 0:
        set_parent(h)
        # print(parent)

val = lca(p1, p2)
if val == 0:
    answer = -1
else:
    # print(val)
    # print(bfs(val, val, 0))
    # print(bfs(val, p1, 0))
    # print(bfs(val, p2, 0))
    answer = bfs(val, p1, 0) + bfs(val, p2, 0)
    # - bfs(val, 0)*2
print(answer)
