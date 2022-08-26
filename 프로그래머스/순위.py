from collections import Counter


def solution(n, results):
    answer = 0
    board = [[0] * n for _ in range(n)]
    for i, j in results:
        board[i - 1][j - 1] = 1
        board[j - 1][i - 1] = -1

    check(board, n)

    # 자신제외 모든판에 승패가 적혀야됨
    for i in range(n):
        if Counter(board[i])[0] == 1:
            answer += 1

    return answer
  
# i 가 j와의 승패를 유추하기 위해 중간에 k와의 비교를 통해 승패를 유추
# 플루이드 와샬의 활용
def check(board, n):
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if board[i][j] == 0:    
                    if board[i][k] == 1 and board[k][j] == 1:
                        board[i][j] = 1
                    elif board[i][k] == -1 and board[k][j] == -1:
                        board[i][j] = -1
