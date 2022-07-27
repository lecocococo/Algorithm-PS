def solution(board, moves):
    answer = 0
    stack = []
    cnt = 0
    for move in moves:
        for i in range(len(board[0])):
            
            if board[i][move-1] == 0:
                continue
            else:
                if len(stack) == 0:
                    stack.append(board[i][move-1])
                else:
                    if stack[-1] == board[i][move-1]:
                        cnt += 1
                        while len(stack) != 0 and stack[-1] == board[i][move-1]:
                            cnt += 1
                            stack.pop()
                    else:
                        stack.append(board[i][move-1]);
                board[i][move-1] = 0
                break
    answer = cnt
    return answer
