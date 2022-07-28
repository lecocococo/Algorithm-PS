import math

def solution(str1, str2):
    answer = 0
    str1 = str1.lower()
    str2 = str2.lower()
    
    s1 = makeSet(str1)
    s2 = makeSet(str2)
    
    if len(s1) ==0 and len(s2) == 0:
        return 65536
    
    cnt = intersect(s1, s2)
    un = union(s1, s2)
    
    answer = math.floor((cnt/un) * 65536)
    return answer

def makeSet(st):
    s = []
    for i in range(len(st) - 1):
        temp = st[i]+st[i+1]
        if temp.isalpha():
            s.append(temp)
    return s

def intersect(s1, s2):
    cnt = 0
    for s in s2:
        if s in s1:
            cnt += 1
            s1.remove(s)
    return cnt

def union(s1, s2):
    return len(s1) + len(s2)
