import math

def solution(left, right):
    answer = 0
    for num in range(left, right + 1):
        val = divisor(num)
        if val %2 ==0:
            answer += num
        else:
            answer -= num
    return answer

def divisor(num):
    cnt = 0
    for i in range(1, int(math.sqrt(num)) + 1):
        if num % i == 0:
            cnt +=1
            if i**2 != num:
                cnt +=1
    return cnt
