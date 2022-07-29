from itertools import permutations
from collections import deque

def solution(expression):
    answer = 0
    
    for priority in list(permutations(['+', '-', '*'], 3)):
        answer = max(answer, abs(result(priority, expression)))
        
    return answer


def result(priority, expression):
    dp = deque()
    num = ''
    for k in expression:
        if k.isdigit():
            num += k
        else:
            dp.append(num)
            num = ''
            dp.append(k)
    dp.append(num)
    
    for op in priority:
        stack = []
        while len(dp) != 0:
            temp = dp.popleft()
            if temp == op:
                result = str(eval(stack.pop()+op+dp.popleft()))
                stack.append(result)
            else:
                stack.append(temp)
        dp = deque(stack)
    return int(dp.pop())
