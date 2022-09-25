from collections import deque


def bfs():
    q = deque()
    q.append([1, 0])
    visited[1] = True
    cnt = 0
    while q:
        val, c = q.popleft()
        # print(c)
        for n in dic[val]:
            if not visited[n]:
                cnt += 1
                visited[n] = True
                q.append([n, cnt])
    return cnt


N = int(input())
M = int(input())
visited = [False] * (N + 1)
dic = {}
for i in range(M):
    a, b = map(int, input().split())
    if a not in dic:
        dic[a] = [b]
    elif a in dic:
        dic[a] = dic[a] + [b]
    if b not in dic:
        dic[b] = [a]
    elif b in dic:
        dic[b] += [a]

# print(dic)
answer = bfs()
print(answer)
