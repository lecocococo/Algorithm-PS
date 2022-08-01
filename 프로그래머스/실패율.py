from collections import Counter

def solution(N, stages):
    answer = []
    users = len(stages)
    temp = Counter(stages)

    fail = {}
    for i in range(1, N+1):
        if temp[i] == 0:
            fail[i] = 0
        else:
            fail[i] = temp[i]/users
            users = users - temp[i]    
    
    fail = sorted(fail.items(), key = lambda x:x[1], reverse = True)
    
    for f in fail:
        answer.append(f[0])
    
    return answer
