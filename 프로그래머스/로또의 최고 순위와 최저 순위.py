def solution(lottos, win_nums):
    answer = []
    zero = 0
    cnt = 0
    for num in lottos:
        if num == 0:
            cnt += 1
            zero += 1
        elif num in win_nums:
            cnt += 1
    
    li = [cnt, cnt - zero]
    rank = [6, 5, 4, 3, 2, 1, 0]
    
    for n in li:
        r = rank.index(n)
        if r < 5:
            answer.append(r+1)
        else:
            answer.append(6)
        
        
    return answer
