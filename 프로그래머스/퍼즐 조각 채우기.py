from collections import Counter

def solution(game_board, table):
    answer = 0
    N = len(game_board)
    puzzle = []
    # 게임 보드
    cnt = 2
    for i in range(N):
        for j in range(N):
            if game_board[i][j] == 0:
                temp = []
                temp = dfs(game_board, N, i, j, cnt, 0, temp)
                puzzle.append(temp)
                cnt += 1
    
    # 테이블
    p2 = []
    cnt = 2
    for i in range(N):
        for j in range(N):
            if table[i][j] == 1:
                temp = []
                temp = dfs(table, N, i, j, cnt, 1, temp)
                p2.append(temp)
                cnt += 1
    
    # print(puzzle)
    # print(p2)
    
    ppp = []
    for p in puzzle:
        x = -1
        y = -1
        z = 100
        w = 100
        # print(p)
        for a, b in p:
            x = max(a, x)
            y = max(b, y)
            z = min(a, z)
            w = min(b, w)
        # print(x, y, z, w)
        # 사각형 범위 땀
        # z w는 사각형에 넣기 위해 사용
        l = abs(x - z) + 1
        m = abs(y - w) + 1
        k = [[0 for _ in range(m)] for _ in range(l)]
        for a, b in p:
            k[a- z][b - w] = 1
        ppp.append(k)
    # for p in ppp:
    #     print(p)
    # print("/////////")
    
    
    ooo = []
    for p in p2:
        x = -1
        y = -1
        z = 100
        w = 100
        # print(p)
        for a, b in p:
            x = max(a, x)
            y = max(b, y)
            z = min(a, z)
            w = min(b, w)
        # print(x, y, z, w)
        # 사각형 범위 땀
        # z w는 사각형에 넣기 위해 사용
        l = abs(x - z) + 1
        m = abs(y - w) + 1
        k = [[0 for _ in range(m)] for _ in range(l)]
        for a, b in p:
            k[a- z][b - w] = 1
        ooo.append(k)
    # for o in ooo:
    #     print(o)
    # print("/////////")
        
    # 회전 및 매칭 구현
    for o in ooo:
        rotated = o
        for _ in range(4):
            rotated = rotate(rotated)
            # print(rotated)
            if rotated in ppp:
                # print(rotated)
                # print(o)
                for r in rotated:
                    # print(Counter(r)[1])
                    answer += Counter(r)[1]
                #     print(Counter(r)[1])
                # print(answer)
                ppp.remove(rotated)
                break
                # ooo.remove(o)
    
    return answer

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
def dfs(board, N, x, y, cnt , k, arr):
    board[x][y] = cnt
    arr.append([x,y])
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if check(nx, ny, N) and board[nx][ny] == k:
            # arr.append((nx, ny))
            dfs(board, N, nx, ny, cnt, k, arr)
    return arr
        
def check(x, y, N):
    return 0<= x < N and 0<= y < N

def rotate(a):
    n = len(a)
    m = len(a[0])

    result = [[0]* n for _ in range(m)]

    for i in range(n):
        for j in range(m):
            result[j][n-i-1] = a[i][j]
    return result
