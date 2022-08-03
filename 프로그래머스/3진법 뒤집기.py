def solution(n):
    answer = 0
    three = []
    while n >= 3:
        val = n//3
        three.append(n - 3 * val)
        n = val
    three.append(n)
    
    a = 0
    for i in three[::-1]:
        answer = answer + i * (3**a)
        a+=1
        
    return answer
