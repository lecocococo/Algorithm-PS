from collections import Counter

def solution(p):
    answer = ''
    temp = ''
    u = ''
    v = ''
    for i in range(0,len(p)):
        temp += p[i]
        if i != len(p)-1 and check(temp):
            u = temp
            v = list(p[i+1:])
            break
        elif i == len(p)-1:
            u = temp
            v = []
            
            
    if correct(u):
        answer+=u
        if len(v) != 0:
            answer+=solution(v)
    else:
        st = '('
        
        if len(v) != 0:
            st += solution(v)
            
        st += ')'
        
        l = len(u)
        u = u[1:l-1]
        answer += st
        
        if len(u) != 0:
            for i in u:
                if i == '(':
                    answer += ')'
                elif i == ')':
                    answer += '('
    return answer

def check(s):
    cnt1 = 0
    cnt2 = 0
    for i in s:
        if i == '(':
            cnt1 += 1
        elif i == ')':
            cnt2 += 1
    if cnt1 == cnt2:
        return True
    else:
        return False
    
def correct(s):
    stack = []
    for ch in s:
        if ch == '(':
            stack.append(ch)   
        elif ch == ')':
            if not stack:
                return False
            else:
                stack.pop()
    if stack:
        return False
    
    return True
