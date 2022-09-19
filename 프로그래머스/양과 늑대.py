from collections import deque

def solution(info, edges):
    global answer
    answer = 0
    graph = [[] for _ in range(len(info))]
    
    for i, j in edges:
        graph[i].append(j)
    
    idx, sheep, wolf = 0, 0, 0
    dfs(info, edges, graph, sheep, wolf, idx, [])
    return answer
        
# child => 갈 수 있는 노드들 모음
def dfs(info, edges, graph, sheep, wolf, idx, child):
    # visited[node] = true
    global answer
    if info[idx] == 0:
        sheep += 1
        answer = max(answer, sheep)
    else:
        wolf += 1
    
    if sheep <= wolf:
        return
    
    child.extend(graph[idx])
    for c in child:
        dfs(info, edges, graph, sheep, wolf, c, [i for i in child if i != c])
