import math

def solution(n, k):
    answer = 0
    arr = []
    
    # 진수 변환
    while n !=0:
        arr.append(n%k)
        n = n//k
    
    # 0기준 split
    st = ''.join(list(map(str,arr[::-1]))).split('0')
    
    # 에라토스테네스의 체 사용(1000000 까진 대부분 코테 허용 범위)
    # 그런데 여긴 진수 변환으로 1000000 넘어갈수 있기때문에 그때 그때 확인해야함
    # 대충 n**0.5 정도 
    # prime = check_prime()
    
    # 판별
    for s in st:
        if s == '':
            continue
        if prime_check(int(s)):
            answer += 1
    
    return answer

# n이 소수인지 아닌지 판별
def prime_check(n):
    if n == 1:
        return False
    for i in range(2, int(math.sqrt(n)+1)):
        if n%i == 0:
            return False
    return True

# 에라토스테네스의 체
def check_prime(n=1000000):
    
    check = [True for _ in range(n+1)]
    for i in range(2, int(math.sqrt(n)+1)):
        if check[i]:
            t = 2
            while i * t <= n:
                check[i*t] = False
                t+=1
    return [k for k in range(2, n+1) if check[k]]
