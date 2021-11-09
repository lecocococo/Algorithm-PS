import sys
from itertools import combinations

t = int(sys.stdin.readline().rstrip())


def GCD(a, b):
    if b > a:
        a, b = b, a
    if b == 0:
        return a
    else:
        return GCD(b, a % b)


for _ in range(t):
    temp = list(map(int, sys.stdin.readline().split()))
    n = temp[0]
    temp = temp[1:]
    data = combinations(temp, 2)
    res = 0
    if n == 1:
        print(n)
    elif n == 2:
        res = GCD(temp[0], temp[1])
        print(res)
    else:
        for i in data:
            res += GCD(i[0], i[1])
        print(res)
