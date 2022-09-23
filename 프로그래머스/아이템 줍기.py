from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    m = [[0 for _ in range(105)] for _ in range(105)]
    for i, j, k, l in rectangle:
        for a in range(i*2, k*2+1):
            for b in range(j*2, l*2+1):
                m[a][b] = -1
    
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2
    
    
    answer = bfs(rectangle, m, characterX, characterY, itemX, itemY)
    return answer

def bfs(rectangle, m, characterX, characterY, itemX, itemY):
    q = deque()
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    q.append([characterX, characterY, 1])
    
    while q:
        val = q.popleft()
        
        if val[0] == itemX and val[1] == itemY:
            return (val[2] - 1)//2
        # 갔던길 check
        m[val[0]][val[1]] = val[2]
        
        for i in range(4):
            nx = val[0] + dx[i]
            ny = val[1] + dy[i]
            
            if m[nx][ny] < 0 and not inRectangle(rectangle, nx, ny):
                q.append([nx, ny, val[2] + 1])
    return -1
            
def inRectangle(rectangle, nx, ny):
    for i, j, k, l in rectangle:
        if i*2 < nx < k*2 and j*2 < ny < l*2:
            return True
    return False
