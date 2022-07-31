from collections import deque

def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    visited = [[0]*m for _ in range(n)]
    visited[0][0] = 1
    
    q = deque([(0, 0)])
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx < n and 0 <= ny < m:
                if maps[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx,ny))
                    
    if visited[n-1][m-1]:
        answer = visited[n-1][m-1]
    else:
        answer = -1
        
    return answer
