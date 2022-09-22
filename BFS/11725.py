from collections import deque


def solution(visited, answer):
    answer = [0] * (N+1)
    q = deque()
    q.append(1)
    while q:
        parent = q.popleft()
        visited[parent] = True
        childs = dic[parent]

        for child in childs:
            if not visited[child]:
                q.append(child)
                answer[child] = parent

    return answer


N = int(input())

check = [0] * (N+1)
visited = [False for _ in range(N+1)]
dic = {}
for i in range(N-1):
    # temp = []
    temp = list(map(int, input().split()))
    if temp[0] not in dic:
        dic[temp[0]] = [temp[1]]
        if temp[1] not in dic:
            dic[temp[1]] = [temp[0]]
        else:
            dic[temp[1]] = dic[temp[1]] + [temp[0]]
    else:
        dic[temp[0]] = dic[temp[0]] + [temp[1]]
        if temp[1] not in dic:
            dic[temp[1]] = [temp[0]]
        else:
            dic[temp[1]] = dic[temp[1]]+[temp[0]]


ans = solution(visited, check)
for i in range(2, len(ans)):
    print(ans[i])
